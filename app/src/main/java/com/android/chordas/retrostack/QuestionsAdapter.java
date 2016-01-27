package com.android.chordas.retrostack;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.chordas.retrostack.model.SOQuestion;
import java.util.List;

/**
 * Created by sam_chordas on 1/22/16.
 */
public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {

  private List<SOQuestion.SOItem> items;

  public QuestionsAdapter(List<SOQuestion.SOItem> items){
    this.items = items;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.question_item, parent, false);
    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    SOQuestion.SOItem item = items.get(position);

    //item.getTitle().replace("&#")

    holder.title.setText(item.getTitle());
  }

  @Override public int getItemCount() {
    if (items == null){
      return -1;
    }
    return items.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{
    public TextView title;
    public TextView link;
    public TextView questionId;
    public ViewHolder(View v){
      super(v);
      title = (TextView) v.findViewById(R.id.title);
    }
  }

  public void swapList(List<SOQuestion.SOItem> items){
    this.items = items;
    notifyDataSetChanged();
  }

}
