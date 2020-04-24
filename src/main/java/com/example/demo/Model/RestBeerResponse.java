package com.example.demo.Model;

import com.example.demo.entity.BeerEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Getter
@JsonInclude(Include.NON_NULL)
public class RestBeerResponse extends RestResponse {

  @JsonProperty("beer_list")
  private List<BeerEntity> beerList;


  @Builder
  public RestBeerResponse(Boolean status, List<BeerEntity> beerList) {
    super(status);
    this.beerList = beerList;
  }
}
