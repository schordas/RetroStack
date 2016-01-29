package com.android.chordas.retrostack.model;

import java.util.List;

/**
 * Created by sam_chordas on 1/25/16.
 */
public class SOQuestion {
  public List<SOItem> getItems() {
    return items;
  }

  public void setItems(List<SOItem> items) {
    this.items = items;
  }

  private List<SOItem> items;


  public static class SOItem{
    String title;
    String link;
    String question_id;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getLink() {
      return link;
    }

    public void setLink(String link) {
      this.link = link;
    }

    public String getQuestion_id() {
      return question_id;
    }

    public void setQuestion_id(String question_id) {
      this.question_id = question_id;
    }
  }


}
