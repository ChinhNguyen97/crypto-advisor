package com.crypto.api.coinbase;

public class ApiData {
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
