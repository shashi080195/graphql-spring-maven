package com.example.demo.controller;

import com.example.demo.Model.RestResponse;
import com.example.demo.mapper.FluxToRest;
import com.example.demo.repository.BeerRepository;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping
@Slf4j
public class GraphQlController {

  private final BeerRepository beerRepository;
  private final FluxToRest fluxToRestService;
  private final GraphQL graphQL;

  @Autowired
  public GraphQlController(final BeerRepository beerRepository,
      final FluxToRest fluxToRestService, GraphQL graphQL) {
    this.beerRepository = beerRepository;
    this.fluxToRestService = fluxToRestService;
    this.graphQL = graphQL;
  }


  @GetMapping("/beer")
  public ResponseEntity<Mono<RestResponse>> getAllBeerList() throws Exception {
    return ResponseEntity.status(HttpStatus.OK)
        .body(
            beerRepository.findAll().collectList().flatMap(fluxToRestService::toRestBeerResponse));
  }

  @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ExecutionResult execute(@RequestBody Map<String, Object> request) throws Exception {
    log.info("request is : {} ", request);
    return graphQL.execute(ExecutionInput.newExecutionInput()
        .query((String) request.get("query"))
        .operationName((String) request.get("operationName"))
        .build());
  }
}
