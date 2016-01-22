package com.android.chordas.tracktrack;

import com.android.chordas.tracktrack.model.BARTModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sam_chordas on 1/21/16.
 */
public final class BARTService {

  public interface TrainAPI {
    @GET("api/etd/{orig}/{key}")
    Call<BARTModel> getTrains(
        @Path("orig") String origin,
        @Path("key") String key);
  }
}
