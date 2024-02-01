# Resturant
## _Food Ordering System_

A simple food ordering system

## APIs

- Order list of the current day. [/api/orders/today]
- Total sale amount of the current day. [/api/sales/current-date-sale-amount]
- All of the registered customer list. [/api/customers]
- Entire order list of a customer. [/api/orders/customerId]
- Max sale day of a certain time range. [/api/sales/max-sale-day?from=2023-01-01&to=2024-02-01]
- Create order [/api/orders]
- Create food [/api/foods]

Don't forget to look at Swagger Docs for paylods

## Features

- Second level caching with Hibernate
- Logging for debugging (Aspect based and logback.xml file-based)
- Swagger api documention (http://localhost:8080/swagger-ui/index.html)


## Tech

Resturant uses a all open source projects to work properly:

- [Spring Boot] - Backend
- [PostgreSQL] - Database
- [Flyway] - Database migration tool
- [Maven] - Build tool
- [Swagger] - API Documentation
- [Docker] - Container

## Installation

The application is maven based.

```sh
mvn clean
mvn install
```

## How to run with Docker

By default, the Docker will expose port 8080, so change this within the
Dockerfile if necessary. When ready, simply use the Dockerfile to
build the image.

```sh
cd resturant
docker build -t resturant .
docker run -p 8080:8080 image_id
```


## License

MIT

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[Spring Boot]: <https://spring.io/>
[PostgreSQL]: <https://www.postgresql.org/>
[Flyway]: <https://www.postgresql.org/>
[Maven]: <https://maven.apache.org/>
[Swagger]: <https://swagger.io/>
[Docker]: <https://www.docker.com/>
