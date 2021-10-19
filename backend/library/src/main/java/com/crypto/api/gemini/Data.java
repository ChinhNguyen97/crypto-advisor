package com.crypto.api.gemini;

/**Utility class to extract and store fron json response **/
public class Data {
  private String ask;
  private String bid;
  private String last;
  private Object volume;

  public Data() {
    this.ask = "";
    this.bid = "";
    this.last = "";
    this.volume = new Object();
  }

  public String getAsk() {
    return this.ask;
  }

  public String getBid() {
    return this.bid;
  }

  public String getLast() {
    return this.last;
  }

  public void setAsk(String ask) {
    this.ask = ask;
  }

  public void setBid(String bid) {
    this.bid = bid;
  }

  public void setLast(String last) {
    this.last = last;
  }


  /** Volume methods are just for completeness.
   *  Object volume is not used **/
  public Object getVolume() {
    return this.volume;
  }

  public void setVolume(Object volume) {
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "ask=" + this.ask + ", bid=" + this.bid + ", last" + this.last;
  }
}