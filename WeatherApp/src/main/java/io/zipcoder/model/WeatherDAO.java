package io.zipcoder.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by rsparks on 10/26/15.
 */
public interface WeatherDAO extends CrudRepository<Weather, Integer> {
    public Weather findTopByOrderByIdDesc();
}
