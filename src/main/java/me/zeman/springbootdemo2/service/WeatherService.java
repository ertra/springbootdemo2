package me.zeman.springbootdemo2.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    public String getWeather(String c1, String c2) {
        String city = c2; // Prague
        String country = c1; // CZ

        if (c2.equals("Lyon")){
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (c2.equals("Nancy")){
            try {
                Thread.sleep(33000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String URL = "http://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "," +
                country +
                "&appid=765590d744a203e6c96eda4b88d4bfdb&units=metric";

        HttpResponse<JsonNode> jsonResponse = null;

        try {
            jsonResponse = Unirest.get(URL)
                    //.header("accept", "application/json")
                    //.queryString("apiKey", "123")
                    //.field("parameter", "value")
                    //.field("foo", "bar")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        JsonNode j = jsonResponse.getBody();
        //JSONObject obj = new JSONObject(jsonResponse.getBody().toString());

        return j.toString();

    }

}
