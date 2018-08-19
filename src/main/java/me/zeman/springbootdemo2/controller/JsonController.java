package me.zeman.springbootdemo2.controller;

import me.zeman.springbootdemo2.model.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class JsonController {

    @GetMapping("/json")
    @ResponseBody
    public ArrayList<Human> greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, HttpServletRequest request, HttpServletResponse response) {

        int r = new Random().nextInt(10);

        Human p = new Human();

        p.setName("Jon");
        p.setAge(new Random().nextInt(10000000));

        Human p2 = new Human();

        p2.setName("Scot");
        p2.setAge(new Random().nextInt(10000000));

        ArrayList<Human> people = new ArrayList();

        people.add(p);
        people.add(p2);

        if (r == 1){
            try {
                System.out.println("my own error");
                throw new Exception("My own exception");
            } catch (Exception e) {
                System.out.println("Exception: " + e.toString());
            }

        } else {
            response.setContentType("application/json");
        }

        return people;
    }

}
