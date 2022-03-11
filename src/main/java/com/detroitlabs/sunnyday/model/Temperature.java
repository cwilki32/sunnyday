package com.detroitlabs.sunnyday.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    double temp;
    int humidity;
    double tempFahrenheit;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double toFahrenheit() {
        tempFahrenheit = Math.round(1.8*(getTemp() - 273) + 32 *1000)/1000;
        return tempFahrenheit;
    }


}
