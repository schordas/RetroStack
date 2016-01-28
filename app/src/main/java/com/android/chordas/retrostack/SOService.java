package com.android.chordas.retrostack;

import com.android.chordas.retrostack.model.SOQuestion;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sam_chordas on 1/21/16.
 */
public final class SOService {

  public interface SOAPI {
    // unsafe=true ensures unsafe response. Prevents HTML escape characters
    @GET("{version}/seartch?page=1&order=desc&sort=activity&unsafe=true")
    Call<SOQuestion> getQuestions(
        @Path("version") String version,
        @Query("intitle") String intitle,
        @Query("site") String site);
  }
}
