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

  public CoinbaseApi(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
    this.webClient = WebClient.create(apiProperties.getBaseUrl());
  }

  /** Coinbase Api call methods **/
  //Api call to Coinbase for specific pair's buy price
  public String fetchBuyPrice(String pair) {
    this.webClient.get().uri(apiProperties.getPricesUrl() + pair + "/buy")
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .subscribe(response -> {
        this.setBuyPrice(dataMapper(response).getAmount());
        System.out.println(this.getBuyPrice());
      });

      return this.getBuyPrice();
      
  }

  //Api call to Coinbase for specific pair's sell price
  public String fetchSellPrice(String pair) {
    this.webClient.get().uri(apiProperties.getPricesUrl() + pair + "/sell")
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .subscribe(response -> {
        this.setSellPrice(dataMapper(response).getAmount());
        System.out.println(this.getSellPrice());
      });

      return this.getSellPrice();
      
  }

  //Internal setters
  protected void setBuyPrice(String price) {
    this.buyPrice = price;
  }

  protected void setSellPrice(String price) {
    this.sellPrice = price;
  }

  //Internal getters
  protected String getBuyPrice() {
    return this.buyPrice;
  }

  protected String getSellPrice() {
    return this.sellPrice;
  }

  /** Utility methods **/
  //Map Json reponse into acessible Java classes
  public static Response dataMapper(String res) {
    ObjectMapper mapper = new ObjectMapper();
    Response response = new Response();
    try {
      response = mapper.readValue(res, Response.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

}