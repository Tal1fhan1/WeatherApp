package com.example.weather_app.model;
import java.io.FileWriter;
import java.io.IOException;

//This class is used to take the information that was collected
//from the API call and writes it into another existing file named
//forecast.txt
public class WriteToFile {
    public static void main(String forecast) {
        try {
            FileWriter myWriter = new FileWriter("forecast.txt");
            myWriter.write(forecast);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
