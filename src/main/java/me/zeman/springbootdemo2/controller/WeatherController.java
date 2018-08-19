package me.zeman.springbootdemo2.controller;

import me.zeman.springbootdemo2.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/weather/{country}/{city}")
    @ResponseBody
    public String helloWorld(@PathVariable String country, @PathVariable String city ,HttpServletRequest request, HttpServletResponse response) {

        String weather = weatherService.getWeather(country,city);

        response.setContentType("application/json");

        return weather;
    }
}
