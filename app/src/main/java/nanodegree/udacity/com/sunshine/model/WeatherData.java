package nanodegree.udacity.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {
    @SerializedName("temp")
    private Temp mTemperature;
    @SerializedName("weather")
    private List<Weather> mWeather;

    public WeatherData(Temp temperature, List<Weather> weather) {
        mTemperature = temperature;
        mWeather = weather;
    }

    public Temp getTemperature() {
        return mTemperature;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }
}
