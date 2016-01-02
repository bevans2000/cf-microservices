# Micro Services example using Spring Boot & Netflix services
Example of using a MicroService application deployed on CloudFoundry.

## Overview
There are 2 micro services that each provide a web service interface. They use the Netflix OSS wrapped in the Spring Cloud project. There is also a Netflix Eureka service deployed that provides a service discovery capability. There are three sub-projects:-
* eureka-server - Eureka wrapper. Cna be deployed locally or in CloudFoundry. This is required because in Cloud Foundry there is no DNS or discovery capabilities such that microservices have to be registered before they cna be called.
* case-server - A basic REST server that utilises Spring Boot. It incorporates Spring JPA and uses an non-persistent in memory database. The Case object is the only entity persisted.
* response-service - Accepts submitted Responses as a POST. These are enriched with Address information retrieved form the Case service before publishing onto a Redis channel for later consumption.

## Services Locally Deployed
When deployed locally via **mvn spring-boot:run**

* Eureka Server @ http://localhost:8761
* Case service HAL Browser @ http://localhost:8081/api/browser/index.html#
* Case service - Case repo @ http://localhost:8081/api/cases

All services have the Spring Acuator (https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html) senabled. Interesting end points
* http:XXX:YYY/health - general status
* http:XXX:YYY/mappings - all registered endpoints
* http:XXX:YYY/metrics - lots of useful counters

## Deploy services on Cloud Foundry
The **manifest.yml** defines the deployment details. Note the application.yml of the individual apps may also use the profile *cloud* to override some details.

### Service URLs on CloudFoundry
All services hosted in the Gov. Trial PaaS must be accessed via HTTPS from the internet. This means that the services can not used specific non standard ports but must use port 8080. There is no problem of clashing of ports because each Cloud Foundry service is hosted oa a dedicated domain, i.e. different virtual hostnames.
