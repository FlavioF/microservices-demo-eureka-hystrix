# Microservices-Demo
Microservices demo using Spring Boot, Spring Cloud, Cofig, Netflix Eureka and Hystrix

# Running with Docker-compose
```
docker-compose build
docker-compose up
```

# Running without Docker
## START CONFIGURATION SERVER
```
cd micro2-config-server
start mvn spring-boot:run
```
## START EUREKA REGISTRY SERVER
```
cd ..
cd micro1-eureka-server
start mvn spring-boot:run
```
## START MICROSERVICES AS EUREKA CLIENT SERVER ######
```
cd ..
cd micro3-word-server
```
(run it in background or one for shell)

```
mvn spring-boot:run -Dspring.profiles.active=article
mvn spring-boot:run -Dspring.profiles.active=customer
mvn spring-boot:run -Dspring.profiles.active=offer
mvn spring-boot:run -Dspring.profiles.active=payment
mvn spring-boot:run -Dspring.profiles.active=product
```

## START MAIN COMPOSITE - MICROSERVICES

```
cd ..
cd micro4-order-server
start mvn spring-boot:run
```

# Links
### CHECK EUREKA

http://localhost:8010/

### CHECK SENTENCE SERVER

http://localhost:8020/order

### CHECK HYSTRIX SERVER

http://localhost:8020/hystrix

ENTER IN HYSTRIX BROWSER ===> http://localhost:8020/hystrix.stream

# Changing Configuration

If you want to change ConfigData you must change uri of application.yml from micro2-config-server to the location of your folder


