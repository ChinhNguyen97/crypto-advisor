package com.crypto.api.coinbase;

import reactor.core.publisher.Mono;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**Main class for Coinbase Api handling **/

@Service
@EnableConfigurationProperties(ApiProperties.class)
public class CoinbaseApi {

  private final ApiProperties apiProperties;
  private final WebClient webClient;

  public CoinbaseApi(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
    this.webClient = WebClient.create(apiProperties.getBaseUrl());
  }

  /** Coinbase Api call methods **/
  //Api call to Coinbase for specific pair's buy price
  public Mono<String> fetchBuyPrice(String pair) {
    return this.webClient.get().uri(apiProperties.getPricesUrl() + pair + "/buy")
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .flatMap(res -> this.extract(res));
  }

  //Api call to Coinbase for specific pair's sell price
  public Mono<String> fetchSellPrice(String pair) {
    return this.webClient.get().uri(apiProperties.getPricesUrl() + pair + "/sell")
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .flatMap(res -> this.extract(res));
      
  }

  //Extract method to extract the amount and pass it down the line.
  protected Mono<String> extract(String response) {
    return Mono.just(dataMapper(response).getAmount());
  } 

  /** Utility methods **/
  //Map Json reponse into acessible Java classes
  protected static Response dataMapper(String res) {
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