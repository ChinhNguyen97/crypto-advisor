package com.crypto.api.gemini;

import reactor.core.publisher.Mono;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/** Main class for Gemini Api handling **/

@Service
@EnableConfigurationProperties(ApiProperties.class)
public class GeminiApi {

  private final ApiProperties apiProperties;
  private final WebClient webClient;

  public GeminiApi(ApiProperties apiProperties) {
    this.apiProperties = apiProperties;
    this.webClient = WebClient.create(apiProperties.getBaseUrl());
  }

  /** Gemini Api call methods **/
  //Api call to gemini for specific pair's buy price
  public Mono<String> fetchBuyPrice(String pair) {
    return this.webClient.get().uri(apiProperties.getPricesUrl() + pair)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .flatMap(res -> this.extract(res,"buy"));
  }

  //Api call to gemini for specific pair's sell price
  public Mono<String> fetchSellPrice(String pair) {
    return this.webClient.get().uri(apiProperties.getPricesUrl() + pair)
      .accept(MediaType.APPLICATION_JSON)
      .retrieve()
      .bodyToMono(String.class)
      .flatMap(res -> this.extract(res, "sell"));
  }

  //Extract method to extract the amount and pass it down the line.
  protected Mono<String> extract(String response, String type) {
    if (type.equals("buy")) {
      return Mono.just(dataMapper(response).getAsk());
    } else {
      return Mono.just(dataMapper(response).getBid());
    }
  }

  /** Utility methods **/
  //Map Json reponse into acessible Java classe
  public static Data dataMapper(String res) {
    ObjectMapper mapper = new ObjectMapper();
    Data response = new Data();
    try {
      response = mapper.readValue(res, Data.class);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return response;
  }

}