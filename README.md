# graphql-spring-maven
spring boot web restful app with graphql and mongodb

## Features
  - uses mongodb to store data
  - uses graphql with spring boot
  - create simple restful api and do graphql query with curl requests
  
## How to Setup
  - create an application.properties file in src/main/resources
  ```
  server.port = 9000
  spring.data.mongodb.uri=mongodb://<YOUR_MONGODB_URI>
  ```
  
## Dummy data used to store in db
```javascript
[
  {
    "_id": "5d83113f1e7e6066e15b788b",
    "abv": "0.05",
    "ibu": "",
    "id": 1436,
    "name": "Pub Beer",
    "style": "American Pale Lager",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  },
  {
    "_id": "5d83113f1e7e6066e15b788c",
    "abv": "0.06",
    "ibu": "",
    "id": 2265,
    "name": "Devils Cup",
    "style": "American Pale Ale (APA)",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://images/f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  },
  {
    "_id": "5d83113f1e7e6066e15b788d",
    "abv": "0.07",
    "ibu": "",
    "id": 2264,
    "name": "Rise of the Phoenix",
    "style": "American IPA",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://images/f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  },
  {
    "_id": "5d83113f1e7e6066e15b788e",
    "abv": "0.09",
    "ibu": "",
    "id": 2263,
    "name": "Sinister",
    "style": "American Double / Imperial IPA",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://images/f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  },
  {
    "_id": "5d83113f1e7e6066e15b788f",
    "abv": "0.07",
    "ibu": "",
    "id": 2262,
    "name": "Sex and Candy",
    "style": "American IPA",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://images/f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  },
  {
    "_id": "5d83113f1e7e6066e15b7890",
    "abv": "0.07",
    "ibu": "",
    "id": 2261,
    "name": "Black Exodus",
    "style": "Oatmeal Stout",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://images/f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  },
  {
    "_id": "5d83113f1e7e6066e15b7891",
    "abv": "0.06",
    "ibu": "",
    "id": 2259,
    "name": "Foreman",
    "style": "American Porter",
    "ounces": 12,
    "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBxBBpsAEiZCeigZfpU7AOFYlO9DAzMxEJY1fQ56Xf67C7S5e",
    "icon": "https://images/f941e020-dc4c-11e9-9789-7a9ddbb44424_100x100",
    "price": 50,
    "description": "Beer is one of the oldest[1][2][3] and most widely consumed[4] alcoholic drinks in the world. It is also the third most popular drink overall after water and tea.[5] Beer is brewed from cereal grains—most commonly from malted barley, though wheat, maize (corn), and rice are also used. During the brewing process, fermentation of the starch sugars in the wort produces ethanol and carbonation in the resulting beer.[6] Most modern beer is brewed with hops, which add bitterness and other flavours and act as a natural preservative and stabilizing agent. Other flavouring agents such as gruit, herbs, or fruits may be included or used instead of hops. In commercial brewing, the natural carbonation effect is often removed during processing and replaced with forced carbonation.[7]",
    "quantity": 500,
    "unit": "ml"
  }
]
```

## How to run
```
mvn clean install -U
java -jar ./target/demo-0.0.1-SNAPSHOT.jar
```

## How to do graphql curl requests
```curl
curl --location --request POST 'http://localhost:9000/graphql' \
--header 'Content-Type: application/json' \
--data-raw '{"query":"query{ beers(style:\"American IPA\"){\n        id\n        name\n        style\n    }\n}","variables":{}}'
```
