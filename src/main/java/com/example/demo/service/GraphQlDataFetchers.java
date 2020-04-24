package com.example.demo.service;

import com.example.demo.entity.BeerEntity;
import com.example.demo.repository.BeerCustomRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.lang.reflect.Field;
import org.springframework.stereotype.Component;

@Component
public class GraphQlDataFetchers {

  private final BeerCustomRepository beerRepository;

  public GraphQlDataFetchers(final BeerCustomRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  public DataFetcher getBeerList() {
    return dataFetchingEnvironment -> beerRepository
        .findBeersByCondition(createBeerEntityModel(dataFetchingEnvironment));
  }

  private BeerEntity createBeerEntityModel(DataFetchingEnvironment dataFetchingEnvironment)
      throws IllegalAccessException {

    BeerEntity beerEntity = BeerEntity.builder().build();
    Field[] fields = beerEntity.getClass().getDeclaredFields();
    for (Field field : fields) {
      String fieldKey = field.getName();
      field.setAccessible(true);
      if (dataFetchingEnvironment.getArgument(fieldKey) != null
          && dataFetchingEnvironment.getArgument(fieldKey).equals("") != true) {
        field.set(beerEntity, dataFetchingEnvironment.getArgument(fieldKey));
      }
    }
    return beerEntity;
  }

}
