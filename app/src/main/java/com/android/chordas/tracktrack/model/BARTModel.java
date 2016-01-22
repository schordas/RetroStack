package com.android.chordas.tracktrack.model;

import java.util.List;

/**
 * Created by sam_chordas on 1/21/16.
 */
public class BARTModel {
  private Root root;

  public static class Root{
    private String message;
    private String time;
    private String date;
    private String uri;
    private Station station;

    // **********************
    // Getters and Setters for root
    public String getMessage() {
      return message;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    }

    public String getUri() {
      return uri;
    }

    public void setUri(String uri) {
      this.uri = uri;
    }

    public Station getStation() {
      return station;
    }

    public void setStation(Station station) {
      this.station = station;
    }

    public void setMessage(String message) {
      this.message = message;
    }
    // End Getters and Setters for root
    // ***********************

    // ***********************
    // Nested class Station
    public static class Station{
      private List<Etd> etd;
      private String name;
      private String abbr;

      public List<Etd> getEtd() {
        return etd;
      }

      public void setEtd(List<Etd> etd) {
        this.etd = etd;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public String getAbbr() {
        return abbr;
      }

      public void setAbbr(String abbr) {
        this.abbr = abbr;
      }
    }
    // End nested class Station
    // ************************

    // ************************
    // Nested class Etd
    public static class Etd{//Estimated Time of Departure
      private List<Estimate> estimates;
      private String limited;
      private String destination;
      private String abbreviation;

      public List<Estimate> getEstimates() {
        return estimates;
      }

      public void setEstimates(List<Estimate> estimates) {
        this.estimates = estimates;
      }

      public String getLimited() {
        return limited;
      }

      public void setLimited(String limited) {
        this.limited = limited;
      }

      public String getDestination() {
        return destination;
      }

      public void setDestination(String destination) {
        this.destination = destination;
      }

      public String getAbbreviation() {
        return abbreviation;
      }

      public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
      }
    }
    // End nested class Etd
    // ************************

    // ************************
    // Nested class Estimate
    public static class Estimate{
      private String minutes;
      private String platform;
      private String direction;
      private String length;
      private String color;
      private String hexcolor;
      private String bikeflag;

      public String getMinutes() {
        return minutes;
      }

      public void setMinutes(String minutes) {
        this.minutes = minutes;
      }

      public String getPlatform() {
        return platform;
      }

      public void setPlatform(String platform) {
        this.platform = platform;
      }

      public String getDirection() {
        return direction;
      }

      public void setDirection(String direction) {
        this.direction = direction;
      }

      public String getLength() {
        return length;
      }

      public void setLength(String length) {
        this.length = length;
      }

      public String getColor() {
        return color;
      }

      public void setColor(String color) {
        this.color = color;
      }

      public String getHexcolor() {
        return hexcolor;
      }

      public void setHexcolor(String hexcolor) {
        this.hexcolor = hexcolor;
      }

      public String getBikeflag() {
        return bikeflag;
      }

      public void setBikeflag(String bikeflag) {
        this.bikeflag = bikeflag;
      }
    }
    // End nested class Estimate
    // ************************

  }

  public Root getRoot(){
    return root;
  }

  public void setRoot(Root root){
    this.root = root;
  }

  public List<Root.Etd> getEtds(){
    return root.getStation().getEtd();
  }
}
