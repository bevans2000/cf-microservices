Example of using a MicroService application deployed on CloudFoundry.

== Services Locally Deployed ==
When deployed locally via *mvn spring-boot:run*

* Eureka Server @ http://localhost:8761
* Case service HAL Browser @ http://localhost:8081/api/browser/index.html#
* Case service - Case repo @ http://localhost:8081/api/cases

All services have the Spring Acuator (https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html) senabled. Interesting end points
* http:XXX:YYY/health - general status
* http:XXX:YYY/mappings - all registered endpoints
* http:XXX:YYY/metrics - lots of useful counters

== Deploy services on Cloud Foundry ==
The *manifest.yml* defines the deployment details. Note the application.yml of the individual apps may also use the profile *cloud* to override some details.

=== Service URLs on CloudFoundry ===
