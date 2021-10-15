package com.crypto.demo;

import com.crypto.api.coinbase.CoinbaseApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.crypto.api")
@RestController
public class DemoApplication {

  private final CoinbaseApi coinbaseApi;

  public DemoApplication(CoinbaseApi coinbaseApi) {
    this.coinbaseApi = coinbaseApi;
  }

  @GetMapping("/")
  public String home() {
    return coinbaseApi.message();
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}