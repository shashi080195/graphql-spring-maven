package com.example.demo.repository;

import com.example.demo.entity.BeerEntity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Slf4j
public class BeerCustomRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  public List<BeerEntity> findBeersByCondition(BeerEntity beerEntity)
      throws IllegalAccessException {
    Query query = new Query();
    query.addCriteria(getCriteria(beerEntity));
    return mongoTemplate.find(query, BeerEntity.class);
  }

  private Criteria getCriteria(BeerEntity beerEntity) throws IllegalAccessException {
    Field[] fields = beerEntity.getClass().getDeclaredFields();
    Criteria criteria = new Criteria();
    List<Criteria> criteriaList = new ArrayList<Criteria>();
    for (Field field : fields) {
      field.setAccessible(true);
      String fieldKey = field.getName();
      Object value = field.get(beerEntity);
      if (value != null) {
        if (value.getClass() == String.class) {
          criteriaList.add(Criteria.where(fieldKey).in((String) value));
        } else {
          criteriaList.add(Criteria.where(fieldKey).in(value));
        }
      }
    }

    return criteriaList.size() != 0 ? criteria
        .andOperator(criteriaList.toArray(new Criteria[criteriaList.size()])) : criteria;
  }
}
