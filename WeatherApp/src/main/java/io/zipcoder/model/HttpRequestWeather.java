package io.zipcoder.model;

import org.springframework.boot.json.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by rsparks on 10/26/15.
 */
public class HttpRequestWeather {


    public Weather getWeatherData(String url0) {
        String line = "";
        try {
            URL url = new URL(url0);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            line = in.readLine();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Weather(url0,line);
    }
}