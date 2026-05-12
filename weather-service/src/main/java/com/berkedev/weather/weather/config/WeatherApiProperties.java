package com.berkedev.weather.weather.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "remote-api.weather-api")
@Data
@Slf4j
public class WeatherApiProperties {
    private String baseUrl;
    private String apiKey;

    @PostConstruct
    public void printOnStartup() {
        log.info("Base URL: {}", baseUrl);
        log.info("API key length {}", apiKey !=null ? apiKey.length() : "NULL");
    }
}
