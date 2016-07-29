package nanodegree.udacity.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

public class LocationData {
    @SerializedName("name")
    private String countryName;
    @SerializedName("country")
    private String cityName;

    public LocationData(String countryName, String cityName) {
        this.countryName = countryName;
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }
}
