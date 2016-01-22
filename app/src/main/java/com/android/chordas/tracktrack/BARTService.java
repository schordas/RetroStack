package com.android.chordas.tracktrack;

import com.android.chordas.tracktrack.model.BARTModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sam_chordas on 1/21/16.
 */
public final class BARTService {

  private static final String API_KEY = BuildConfig.BART_API_KEY;

  public interface TrainAPI {
    @GET("api/etd/{orig}/{key}")
    Call<List<BARTModel>> getTrains(
        @Path("orig") String origin,
        @Path("key") String key);
  }
}
