package com.example.weather_app.model;

import java.util.List;

//This class creates all of the variables, getters and setters
//that will be used to retrieve and store the information that
//needs to be displayed to the user.
public class WeatherResponse {
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    private String name;
    private Sys sys;
    private List<Weather> weather;
    private Main main;
    private Wind wind;

    //This gets and sets the name of the country.
    public static class Sys {
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        private String country;
    }

    //This gets and sets a description that describes the type
    //of weather this specific location is having. It also gets
    //and sets a unique id for each weather forecast.
    public static class Weather {
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private int id;
        private String description;
    }

    //This gets and sets the temperature as well as the humidity
    //of that this specific location is experiencing.
    public static class Main {
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        private double temp;
        private int humidity;
    }

    //This gets and sets the wind speed that this
    //specific location is experiencing.
    public static class Wind {
        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        private double speed;
    }
}
