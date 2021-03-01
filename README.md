# CQRS & Event Sourcing

## Launch application

```
mvn spring-boot:run
```

## H2 database

H2 console connection details:

* url: ```http://localhost:8080/h2-console```
  * Driver class: ```org.h2.Driver```
  * JDBC url: ```jdbc:h2:mem:testdb```
  * user: ```sa```
  * password: 

Queries to check database information:

```
SELECT * FROM PRODUCT;
SELECT * FROM SHOPPING_CART;
SELECT * FROM SHOPPING_CART_ITEM;
SELECT * FROM SHOPPING_CART_ITEMS;
SELECT * FROM CART_EXPENDITURE;
```
## Testing

You can find a file named [practice2.cqrs-event-sourcing.postman_collection.json](practice2.cqrs-event-sourcing.postman_collection.json) that you can import in [Postman](https://www.postman.com/), to test the implemented endpoints.

## Author

[David Rojo (@david-rojo)](https://github.com/david-rojo)
