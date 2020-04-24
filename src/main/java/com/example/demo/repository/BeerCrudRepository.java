package com.example.demo.repository;

import com.example.demo.entity.BeerEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BeerCrudRepository extends CrudRepository<BeerEntity, String> {

  List<BeerEntity> findByStyle(String style);

}
