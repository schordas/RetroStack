package com.android.chordas.retrostack;

import com.android.chordas.retrostack.model.SOQuestion;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sam_chordas on 1/21/16.
 */
public final class SOService {

  public interface SOAPI {
    @GET("2.2/search?page=1&order=desc&sort=activity")
    Call<SOQuestion> getQuestions(
        @Query("intitle") String intitle,
        @Query("site") String site);
  }
}
