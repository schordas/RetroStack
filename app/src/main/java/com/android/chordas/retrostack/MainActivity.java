package com.android.chordas.retrostack;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.android.chordas.retrostack.model.SOQuestion;
import com.android.chordas.retrostack.SOService.SOAPI;
import java.util.List;
import java.util.Random;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;



public class MainActivity extends Activity{

  private static final String API_BASE_URL = "https://api.stackexchange.com";
  private Call<SOQuestion> call;
  private SOQuestion question;
  private List<SOQuestion.SOItem> items;
  private QuestionsAdapter questionsAdapter;
  private Random random;
  private final String intitle = "android";
  private final String site = "stackoverflow";
  private String version;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Random boolean used to generate Network error code by changing Stack Overflow API version
    random = new Random();
    if (random.nextBoolean()){
      version = "2.2";
    } else {
      version = "fail";
    }

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    questionsAdapter = new QuestionsAdapter(items);
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.question_list);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(questionsAdapter);

    SOAPI soapi = retrofit.create(SOAPI.class);

    call = soapi.getQuestions(version, intitle, site);
    call.enqueue(new Callback<SOQuestion>() {
      @Override public void onResponse(Response<SOQuestion> response) {
        try {
          question = response.body();
          items = question.getItems();
          questionsAdapter.swapList(items);
        } catch (NullPointerException e){
          Toast toast = null;
          if (response.code() == 401){
            toast = Toast.makeText(MainActivity.this, "Unauthenticated", Toast.LENGTH_SHORT);
          } else if (response.code() >= 400){
            toast = Toast.makeText(MainActivity.this, "Client Error " + response.code()
                + " " + response.message(), Toast.LENGTH_SHORT);
          }
          toast.show();
        }
      }

      @Override public void onFailure(Throwable t) {
        Log.e("getQuestions threw: ", t.getMessage());
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
