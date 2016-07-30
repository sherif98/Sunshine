package nanodegree.udacity.com.sunshine.network;

import nanodegree.udacity.com.sunshine.model.ResultData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPI {
    String URL = "http://api.openweathermap.org/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/data/2.5/forecast/daily")
    Call<ResultData> getWeatherData(@Query("q") String q, @Query("units") String units,
                                    @Query("cnt") String cnt, @Query("APPID") String APPID);
}
