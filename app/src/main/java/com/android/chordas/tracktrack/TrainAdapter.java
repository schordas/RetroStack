package com.android.chordas.tracktrack;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by sam_chordas on 1/22/16.
 */
public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.ViewHolder> {

  private List<TrainInfo> trainInfo;

  public TrainAdapter(List<TrainInfo> trainInfo){
    this.trainInfo= trainInfo;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.train_item, parent, false);
    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    TrainInfo train = trainInfo.get(position);
    holder.minTextView.setText(train.getMinutes());
    holder.destTextView.setText(train.getDestination());
    holder.trainItem.setBackgroundColor(Color.parseColor(train.getHexcolor()));
  }

  @Override public int getItemCount() {
    if (trainInfo != null){
      return -1;
    }
    return trainInfo.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{
    public TextView destTextView;
    public TextView minTextView;
    public LinearLayout trainItem;
    public ViewHolder(View v){
      super(v);
      destTextView = (TextView) v.findViewById(R.id.destination_text_view);
      minTextView = (TextView) v.findViewById(R.id.minutes_text_view);
      trainItem = (LinearLayout) v.findViewById(R.id.train_item);
    }
  }

}
