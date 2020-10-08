# Shop
This project demonstrates a back-end of e-commerce application. This project was generated with SpringBoot.
- - -
## Table of contents
* [General info](#shop)
* [Features](#features)
* [Setup](#setup)

### Build with
- - -
Project is created with:
* Java 11
* Spring Boot 2.3.1
* Spring Security
* Spring Data JPA
* JWT Authentication
* Hibernate validator 6.1.5
* MySQL 8.0.20
* Maven
* Lombok
* Hazelcast 4.0.2
* Spring Batch
* JUnit
* Apache POI
* IText 5
* OpenCSV
* SonarQube
* Elasticsearch
* Swagger

#### Features
___
* Generating reports in CSV, Doc, Json, Pdf, Xls
* Generating public and private emails
* Dynamic addition of products by CSV file, which is listened to from the folder by watchservice
   and processed by springbatch, working on multiple threads
* Cache with Hazelcast implementation for product storage
* Products function - save, delete, pagable, search for products
* Users functions - save, search, pagable, user downloads
* Basket functions - add, delete, basket is assigned to user
* Versioning of data
* Regex
* Spring Security authorization based on a token

##### Setup
_ _ _
Clone this repo to your desktop. Run applications using Spring Boot.
You will then be able to access it at localhost:8080.

