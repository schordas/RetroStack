package com.android.chordas.tracktrack;

import com.android.chordas.tracktrack.model.BARTModelRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sam_chordas on 1/21/16.
 */
public final class BARTService {

  public interface TrainAPI {
    @GET("api/etd.aspx?cmd=etd")
    Call<BARTModelRoot> getTrains(
        @Query("orig") String origin,
        @Query("key") String key);
  }
}
