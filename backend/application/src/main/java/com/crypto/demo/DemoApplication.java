package com.crypto.demo;

import com.crypto.api.coinbase.CoinbaseApi;
import com.crypto.api.gemini.GeminiApi;
import reactor.core.publisher.Mono;

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
    //coinbaseApi.fetchBuyPrice("BTC-USD").subscribe(v -> { System.out.println("Buy: " + v);});
    //coinbaseApi.fetchSellPrice("BTC-USD").subscribe(v -> { System.out.println("Sell" + v);});
    geminiApi.fetchBuyPrice("btcusd").subscribe(v -> { System.out.println("Buy: " + v);});
    geminiApi.fetchSellPrice("btcusd").subscribe(v -> { System.out.println("Sell: " + v);});

  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}