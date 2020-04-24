package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "beerList")
@TypeAlias("beerList")
@Getter
@Setter
@Builder
public class BeerEntity {
    @Id
    private String _id;

    private String abv;
    private String ibu;
    private Integer id;
    private String name;
    private String style;
    private Float ounces;
    private String image;
    private String icon;
    private Float price;
    private String description;
    private Integer quantity;
    private String unit;
}
