package com.android.chordas.tracktrack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.android.chordas.tracktrack.model.BARTModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;
import com.android.chordas.tracktrack.BARTService.TrainAPI;


public class MainActivity extends Activity{

  private static final String API_BASE_URL = "http://api.bart.gov";
  private Call<List<BARTModel>> call;
  private String origin;
  private static final String API_KEY = BuildConfig.BART_API_KEY;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build();

    TrainAPI bartTrain = retrofit.create(TrainAPI.class);

    call = bartTrain.getTrains(origin, API_KEY);
    call.enqueue(new Callback<List<BARTModel>>() {
      @Override public void onResponse(Response<List<BARTModel>> response) {

      }

      @Override public void onFailure(Throwable t) {
        Log.e("getTrains threw: ", t.getMessage());
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    // Unsubscribe
    call.cancel();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
