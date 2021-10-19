package com.crypto.api.coinbase;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
public class ApiProperties {

  /** Get endpoint uri from application.properties 
   *  This template can be used to extend Api calls. **/

  private String coinbasePair;
  private String coinbaseBuy;
  private String coinbaseSell;
  private String coinbaseSpot;

  /** Property getters **/
  public String getPair() {
    return coinbasePair;
  }

  public String getBuy() {
    return coinbaseBuy;
  }

  public String getSell() {
    return coinbaseSell;
  }

  public String getSpot() {
    return coinbaseSpot;
  }

  /** Property setters **/
  public void setCoinbasePair(String coinbasePair) {
    this.coinbasePair = coinbasePair;
  }

  public void setCoinbaseBuy(String coinbaseBuy) {
    this.coinbaseBuy = coinbaseBuy;
  }

  public void setCoinbaseSell(String coinbaseSell) {
    this.coinbaseSell = coinbaseSell;
  }

  public void setCoinbaseSpot(String coinbaseSpot) {
    this.coinbaseSpot = coinbaseSpot;
  }
}