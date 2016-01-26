package com.android.chordas.tracktrack;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.chordas.tracktrack.model.BARTModelRoot.Etd;
import com.android.chordas.tracktrack.model.BARTModelRoot.Estimate;
import java.util.List;

/**
 * Created by sam_chordas on 1/22/16.
 */
public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.ViewHolder> {

  private List<Etd> etds;

  public TrainAdapter(List<Etd> etds){
    this.etds = etds;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.train_item, parent, false);
    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Etd trainDeparture = etds.get(position);
    Estimate estimate = trainDeparture.getEstimates().get(0);
    holder.minTextView.setText(trainDeparture.getMinutes());
    holder.destTextView.setText(trainDeparture.getDestination());
    holder.trainItem.setBackgroundColor(Color.parseColor(estimate.getHexcolor()));
  }

  @Override public int getItemCount() {
    if (etds != null){
      return -1;
    }
    return etds.size();
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
