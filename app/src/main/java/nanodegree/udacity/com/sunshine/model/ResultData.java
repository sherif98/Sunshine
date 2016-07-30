package nanodegree.udacity.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultData {
    @SerializedName("city")
    private LocationData mLocationData;
    @SerializedName("list")
    private List<ForecastData> mWeatherData;

    public ResultData(LocationData locationData, List<ForecastData> weatherData) {
        mLocationData = locationData;
        mWeatherData = weatherData;
    }

    public LocationData getLocationData() {
        return mLocationData;
    }

    public List<ForecastData> getWeatherData() {
        return mWeatherData;
    }
}
