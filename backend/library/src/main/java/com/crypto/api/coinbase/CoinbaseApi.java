package com.crypto.api.coinbase;

import reactor.core.publisher.Mono;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Service
@EnableConfigurationProperties(ApiProperties.class)
public class CoinbaseApi {

  private final ApiProperties apiProperties;
  private final WebClient webClient;

  private String buyPrice;
  private String sellPrice;
  private String spotPrice;

  public CoinbaseApi(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
    this.webClient = WebClient.create("https://api.coinbase.com");
  }

  public void fetchBuyPrice(String pair) {
    this.webClient.get().uri("/v2/prices/{pair}/buy", pair)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .subscribe(response -> {
        this.buyPrice = dataMapper(response);
        System.out.print(this.buyPrice);
      });
  }

  /*
  public String getSellPrice(String pair) {
    this.result = this.webClient.get().uri("/v2/prices/{pair}/sell", pair).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);
    this.result.subscribe(response -> {
      System.out.println(dataMapper(response));
    });
  }
  */

  public static String dataMapper(String v) {
    ObjectMapper mapper = new ObjectMapper();
    String amount = "";
    try {
      ApiData apiData = mapper.readValue(v, ApiData.class);
      amount = apiData.getAmount();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return amount;
  }
/*
  public static String message(String v) {
    return this.amount;
  }

*/

}