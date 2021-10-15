package com.crypto.api.coinbase;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ApiProperties.class)
public class CoinbaseApi {

  private final ApiProperties apiProperties;

  public CoinbaseApi(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
  }

  public String message() {
    return this.apiProperties.getMessage();
  }
}