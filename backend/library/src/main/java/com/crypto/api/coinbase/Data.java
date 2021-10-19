package com.crypto.api.coinbase;

/**Utility class to extract and store data object fron json response **/
public class Data {
  private String base;
  private String currency;
  private String amount;

  public Data() {
    this.base = "";
    this.currency = "";
    this.amount = "";
  }

  public String getBase() {
    return this.base;
  }

  public String getCurrency() {
    return this.currency;
  }

  public String getAmount() {
    return this.amount;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "base=" + this.base + ", currency=" + this.currency + ", amount" + this.amount;
  }
}