package com.dld.hll.financial;

import static org.junit.Assert.assertTrue;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()


                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getName().equals("brand");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .serializeNulls()
                // creator
                .setVersion(2.0)
                .create();

        Car car = new Car();
        car.brand = "Ford";
        car.doors = 4;
        System.out.println(gson.toJson(car));
    }

    @Test
    public void test() {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(Car.class, new CarCreator());

        Gson gson  = gsonBuilder.create();


        String carJson = "{ \"doors\" : 4 }";

        Car car = gson.fromJson(carJson, Car.class);

        System.out.println(car.brand);
    }

    @Test
    public void jreader() {

        String json = "{\"brand\" : \"Toyota\", \"doors\" : 5}";

        JsonReader jsonReader = new JsonReader(new StringReader(json));

        try {
            while(jsonReader.hasNext()){
                JsonToken nextToken = jsonReader.peek();
                System.out.println(nextToken);

                if(JsonToken.BEGIN_OBJECT.equals(nextToken)){

                    jsonReader.beginObject();

                } else if(JsonToken.NAME.equals(nextToken)){

                    String name  =  jsonReader.nextName();
                    System.out.println(name);

                } else if(JsonToken.STRING.equals(nextToken)){

                    String value =  jsonReader.nextString();
                    System.out.println(value);

                } else if(JsonToken.NUMBER.equals(nextToken)){

                    long value =  jsonReader.nextLong();
                    System.out.println(value);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
