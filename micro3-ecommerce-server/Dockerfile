#
# Config Server Dockerfile
#
FROM java:openjdk-8-jdk-alpine

# Add OpenSSH
RUN apk update && apk add openssh

# Add directly the jar
ENV SPRING_PROFILES=dev
#ENV CONFIG_SERVER_IP=config
#ENV SERVER_IP=eureka
#ENV PREFER_IP_ADDRESS=true
ADD ./target/ecommerce-server-1.0.jar /app.jar
ADD start.sh /start.sh
RUN chmod 777 /start.sh
RUN sh -c 'touch /app.jar'
VOLUME /tmp

EXPOSE 8081
ENTRYPOINT ["java"]
