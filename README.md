# cloudApps-eventSourcing-cqrs


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
