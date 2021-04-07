# Search API

## Description

This is a Spring MVC based API, for website search. Created to serve as back-end for future engine applications for web and mobile.

## Pre-requisites

For the API to work, you must have the requirements described below:

 - PostgreSQL installed, with a Database named as: search-api

## Documentation

The API uses swagger UI as documentation, which can be found, in the runtime execution, as:

http://localhost:8080/swagger-ui/

## Setup

In order for Flyway Migration to work properly, you must switch the configurations below in src/main/resources/application.properties:

 - spring.datasource.url = jdbc:postgresql://localhost:YOUR_POSTGRESQL_SERVER_PORT/search-api -> switch YOUR_POSTGRESQL_SERVER_PORT for the port of your postgresql server
 - spring.datasource.username = YOUR_POSTGRESQL_USER -> switch for your postgresql user
 - spring.datasource.password = YOUR_POSTGRESQL_PASS -> switch for the postgres password

 These changes must be done to Application.java, located in com.searchapi.config.flyway

 - String url = "jdbc:postgresql://localhost:YOUR_POSTGRESQL_SERVER_PORT/search-api";
 - String user = "YOUR_POSTGRESQL_USER";
 - String password = "YOUR_POSTGRESQL_PASS";
