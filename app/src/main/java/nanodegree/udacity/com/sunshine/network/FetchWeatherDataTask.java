package nanodegree.udacity.com.sunshine.network;

import android.os.AsyncTask;

import java.io.IOException;

import nanodegree.udacity.com.sunshine.model.ResultData;
import retrofit2.Call;

public class FetchWeatherDataTask extends AsyncTask<String, Void, ResultData> {

    private DataDownloadFinishedCommand mCommand;

    public FetchWeatherDataTask(DataDownloadFinishedCommand command) {
        mCommand = command;
    }

    @Override
    protected ResultData doInBackground(String... parameters) {

        OpenWeatherAPI service = OpenWeatherAPI.retrofit.create(OpenWeatherAPI.class);
        Call<ResultData> call = service.getWeatherData(parameters[0], parameters[1], parameters[2],
                APIKeys.WEATHER_API_KEY);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ResultData resultData) {
        mCommand.transferData(resultData);
    }
}
