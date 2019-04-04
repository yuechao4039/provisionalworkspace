package com.dld.hll.financial;

import com.google.gson.annotations.Expose;

public class Car {

    @Expose
    public String brand = null;

    @Expose(serialize = false)
    public int doors = 0;
}