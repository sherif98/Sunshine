package nanodegree.udacity.com.sunshine.network;

import nanodegree.udacity.com.sunshine.model.ResultData;

public interface DataDownloadFinishedCommand {
    void transferData(ResultData data);
}
