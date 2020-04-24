package com.example.demo.repository;

import com.example.demo.entity.BeerEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BeerRepository extends ReactiveMongoRepository<BeerEntity, String> {

  Flux<BeerEntity> findByStyle(String style);

}
