package com.crypto.api.gemini;

import org.springframework.boot.context.properties.ConfigurationProperties;


/** Get properties from application.properties 
  * This template can be used to expand Api calls. **/

@ConfigurationProperties("service")
public class ApiProperties {

  private String geminiPricesUrl;
  private String geminiBaseUrl;

  /** Property getters **/
  public String getPricesUrl() {
    return geminiPricesUrl;
  }

  public String getBaseUrl() {
    return geminiBaseUrl;
  }


  /** Property setters **/
  public void setGeminiPricesUrl(String geminiPricesUrl) {
    this.geminiPricesUrl = geminiPricesUrl;
  }

  public void setGeminiBaseUrl(String geminiBaseUrl) {
    this.geminiBaseUrl = geminiBaseUrl;
  }
}