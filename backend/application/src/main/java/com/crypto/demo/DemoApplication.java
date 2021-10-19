package com.crypto.demo;

import com.crypto.api.coinbase.CoinbaseApi;
import com.crypto.api.gemini.GeminiApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.crypto.api")
@RestController
public class DemoApplication {

  private final CoinbaseApi coinbaseApi;
  private final GeminiApi geminiApi;

  public DemoApplication(CoinbaseApi coinbaseApi, GeminiApi geminiApi) {
    this.coinbaseApi = coinbaseApi;
    this.geminiApi = geminiApi;
  }

  @GetMapping("/")
  public void home() {
    coinbaseApi.fetchBuyPrice("BTC-USD");
    coinbaseApi.fetchSellPrice("BTC-USD");
    geminiApi.fetchBuyPrice("btcusd");
    geminiApi.fetchSellPrice("btcusd");
    //return coinbaseApi.fetchBuyPrice("BTC-USD");
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}