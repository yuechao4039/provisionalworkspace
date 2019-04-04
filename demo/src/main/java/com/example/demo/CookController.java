package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class CookController {

    @RequestMapping("/cook")
    public String cook(HttpServletRequest request) {

        return "cook";
    }

    @RequestMapping("/gcook")
    public String gcook(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        return "gcook";
    }


    @RequestMapping("/fcook")
    public String fcook(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        System.out.println(session != null ? session.getId() : session);
        return "fcook";
    }


}
