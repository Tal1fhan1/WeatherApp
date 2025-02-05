package com.example.weather_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This class is the one that initiates and runs the program.
@SpringBootApplication
public class WeatherAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}
}
