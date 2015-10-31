package io.zipcoder.controller;

import io.zipcoder.model.HttpRequestWeather;
import io.zipcoder.model.Weather;
import io.zipcoder.model.WeatherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by rsparks on 10/26/15.
 */




@Controller
public class WeatherController {
    @Autowired
    private WeatherDAO weatherDAO;


    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    @ResponseBody
    public Weather shipData() {
        return this.weatherDAO.findTopByOrderByIdDesc();
    }


    //4145381 cityid
}
