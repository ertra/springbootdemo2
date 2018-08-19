package me.zeman.springbootdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {

        @GetMapping("/one")
        @ResponseBody
        public String one() {
            return "greeting";
        }


}
