package me.zeman.springbootdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller

public class MyController {

    @GetMapping("/one")
    @ResponseBody
    public String one() {
        return "One response";
    }

    @GetMapping("/two")
    @ResponseBody
    public String two() {
        return "Two response";
    }

    @GetMapping("/three/{id}")
    @ResponseBody
    public String three() {

        Random r = new Random();
        int cnt = r.nextInt(10000000);

        return "Three response: " + cnt;
    }

}

