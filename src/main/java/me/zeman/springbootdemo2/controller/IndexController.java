package me.zeman.springbootdemo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "My mustache template.");
        return "welcome";
    }

    @RequestMapping("/serviceUnavailable")
    public String ServiceUnavailable() {
        throw new ServiceUnavailableException();
    }

    @RequestMapping("/bang")
    public String bang() {
        throw new RuntimeException("Boom");
    }

    @RequestMapping("/insufficientStorage")
    public String insufficientStorage() {
        throw new InsufficientStorageException();
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    private static class ServiceUnavailableException extends RuntimeException {

    }

    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    private static class InsufficientStorageException extends RuntimeException {

    }


}
