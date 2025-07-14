package com.meteoApi.ControlloTempo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeteoService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String getMeteoData(double lat, double lon) {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&hourly=temperature_2m";
        return restTemplate.getForObject(url, String.class);
    }
}
