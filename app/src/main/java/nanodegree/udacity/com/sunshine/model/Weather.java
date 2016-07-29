package nanodegree.udacity.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main")
    private String weatherType;

    public Weather(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getWeatherType() {
        return weatherType;
    }
}
