# Microservices-Demo
Microservices demo using Spring Boot, Spring Cloud, Cofig, Netflix Eureka and Hystrix


# Running with Docker-compose
```
mvn package -DskipTests
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
cd micro3-ecommerce-server
```
(run it in background or one for shell)
ENSURE that eureka and config already listed in eureka server
```
start mvn spring-boot:run -Dspring.profiles.active=purchase
start mvn spring-boot:run -Dspring.profiles.active=customer
start mvn spring-boot:run -Dspring.profiles.active=offer
start mvn spring-boot:run -Dspring.profiles.active=payment
start mvn spring-boot:run -Dspring.profiles.active=product
```

## START MAIN COMPOSITE - MICROSERVICES

```
cd ..
cd micro4-order-server
start mvn spring-boot:run
```

# Links


### CHECK EUREKA

Outside Docker: http://localhost:8761/
Inside Docker: http://localhost:9761/

### CHECK SENTENCE SERVER

Outside Docker: http://localhost:8020/order
Inside Docker: http://localhost:9020/order

### CHECK HYSTRIX SERVER

Outside Docker: http://localhost:8020/order
Inside Docker: http://localhost:9020/hystrix

# Changing Configuration

If you want to change ConfigData you must change uri of application.yml from micro2-config-server to the a GIT location of your folder.
To test it using a file system backend take a look into this link: https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html


