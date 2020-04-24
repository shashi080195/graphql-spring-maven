package com.example.demo.mapper;

import com.example.demo.Model.RestBeerResponse;
import com.example.demo.entity.BeerEntity;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class FluxToRest {

  public Mono<RestBeerResponse> toRestBeerResponse(List<BeerEntity> beerEntities) {
    return Mono.just(RestBeerResponse.builder().status(true).beerList(beerEntities).build());
  }

}
