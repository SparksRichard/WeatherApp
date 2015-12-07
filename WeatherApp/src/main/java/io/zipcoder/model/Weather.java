package io.zipcoder.model;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rsparks on 10/26/15.
 */
@Entity
@Table(name = "weather")
public class Weather {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String url;

    @NotNull
    private String data;

    public Weather(String url0, String data0){
        this.url = url0;
        this.data = data0;
    }

    public Weather(){ };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String Url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
