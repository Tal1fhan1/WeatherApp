package com.example.weather_app.controller;

import org.springframework.ui.Model;
import com.example.weather_app.model.WeatherResponse;
import com.example.weather_app.model.WriteToFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

//This class collects the contents of the API key from
//templates/application.properties, initiates the mapping
//of items and returns a response.
@Controller
public class WeatherController {

    @Value("${api.key}")
    private String apiKey;
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    //This function is used to make an API call to openweathermap.org
    //and take certain actions based on whether the call returns a
    //valid response.
    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appId=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        //If the API call returns a valid response, all of the relevant
        //information that is gathered from that response is passed
        //on to the HTML elements in weather.html and displayed on
        //that page for the user to see the full weather forecast they
        //requested.
        if (weatherResponse != null) {
            model.addAttribute("city", weatherResponse.getName());
            model.addAttribute("country", weatherResponse.getSys().getCountry());
            model.addAttribute("weatherDescription", weatherResponse.getWeather().get(0).getDescription());
            model.addAttribute("temperature", weatherResponse.getMain().getTemp());
            model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
            model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());
            String weatherIcon = "wi wi-owm-" + weatherResponse.getWeather().get(0).getId();
            model.addAttribute("weatherIcon", weatherIcon);

            String forecast = "City: " + weatherResponse.getName() + " |" + " Country: " + weatherResponse.getSys().getCountry() + " |" + " Weather Description: " + weatherResponse.getWeather().get(0).getDescription() + " |" + " Temperature: " + weatherResponse.getMain().getTemp() + " Degrees Celsius |" + " Humidity: " + weatherResponse.getMain().getHumidity() + "% |" + " Wind Speed: " + weatherResponse.getWind().getSpeed() + "m/s";
            WriteToFile.main(forecast);
        } else {
            model.addAttribute("error", "City not found.");
        }
        return "weather";

    }
}
