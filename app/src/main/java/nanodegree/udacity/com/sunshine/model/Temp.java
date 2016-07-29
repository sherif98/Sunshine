package nanodegree.udacity.com.sunshine.model;

import com.google.gson.annotations.SerializedName;

public class Temp {
    @SerializedName("min")
    private double minTemperature;
    @SerializedName("max")
    private double maxTemperature;

    public Temp(double minTemperature, double maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }
}
