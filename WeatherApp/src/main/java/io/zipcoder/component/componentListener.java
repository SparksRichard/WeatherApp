package io.zipcoder.component;

import io.zipcoder.model.HttpRequestWeather;
import io.zipcoder.model.WeatherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by rsparks on 10/27/15.
 */

@Component
public class componentListener implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private WeatherDAO weatherDAO;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        try{
            HttpRequestWeather httpRequestWeather = new HttpRequestWeather();
            weatherDAO.save(httpRequestWeather.getWeatherData("http://api.openweathermap.org/data/2.5/forecast/city?id=4145381&APPID=6b5a2f0d03f24f94748b13fa796d5a0c"));
        }catch (Exception e){

        }
    }
}
