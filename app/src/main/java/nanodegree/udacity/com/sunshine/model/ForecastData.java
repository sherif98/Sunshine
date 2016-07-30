package nanodegree.udacity.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastData {
    @SerializedName("temp")
    private Temp mTemperature;
    @SerializedName("weather")
    private List<Weather> mWeather;

    public ForecastData(Temp temperature, List<Weather> weather) {
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
