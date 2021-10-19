package com.crypto.api.coinbase;

/** Utility class to unpack Json response **/
public class Response {
  private Data data;

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  public String getAmount(){
    return data.getAmount();
  }

  @Override
  public String toString() {
    return "" + data;
  }

}
