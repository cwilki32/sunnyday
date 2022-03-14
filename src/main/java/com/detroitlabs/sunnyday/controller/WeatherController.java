package com.detroitlabs.sunnyday.controller;

import com.detroitlabs.sunnyday.model.Coordinates;
import com.detroitlabs.sunnyday.model.Forecast;
import com.detroitlabs.sunnyday.model.Temperature;
import com.detroitlabs.sunnyday.model.WeatherDescription;
import com.detroitlabs.sunnyday.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
    WeatherService weatherService = new WeatherService(); //add a WeatherService property

    @ResponseBody
    @RequestMapping("/")
    public String displayWeather() {
        Forecast forecast = weatherService.fetchWeatherData();
        Temperature temperature = forecast.getTemperature();
        WeatherDescription weather = forecast.getWeather().get(0);

        return "The current temperature in " + forecast.getName() + " " + temperature.toFahrenheit() +  "" +
                " degrees fahrenheit. The current humidity is " + temperature.getHumidity() + "<br>" +
                "The wind speed is currently " + forecast.getWind().getSpeed() + " mph." + weather.getDescription()
                + " " + weather.getIcon() + " " + weather.getMain() + " " + weather.getId() + "<br>" +
                "Longitude: " + forecast.getCoord().getLon() + "<br>" + "Latitude: " + forecast.getCoord().getLat();
//        return "home"; default

    }
}
