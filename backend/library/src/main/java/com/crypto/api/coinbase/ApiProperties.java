package com.crypto.api.coinbase;

import org.springframework.boot.context.properties.ConfigurationProperties;


/** Get properties from application.properties 
  * This template can be used to expand Api calls. **/

@ConfigurationProperties("service")
public class ApiProperties {

  private String coinbasePricesUrl;
  private String coinbaseBaseUrl;

  /** Property getters **/
  public String getPricesUrl() {
    return coinbasePricesUrl;
  }

  public String getBaseUrl() {
    return coinbaseBaseUrl;
  }


  /** Property setters **/
  public void setCoinbasePricesUrl(String coinbasePricesUrl) {
    this.coinbasePricesUrl = coinbasePricesUrl;
  }

  public void setCoinbaseBaseUrl(String coinbaseBaseUrl) {
    this.coinbaseBaseUrl = coinbaseBaseUrl;
  }
}