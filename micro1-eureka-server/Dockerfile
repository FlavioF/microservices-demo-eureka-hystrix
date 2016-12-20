#
# Config Server Dockerfile
#
# FROM alpine:3.4
FROM java:openjdk-8-jdk-alpine

MAINTAINER Pras Biswas

# Add OpenSSH
RUN apk update && apk add openssh

# Add directly the jar
ENV SPRING_PROFILES=dev
#ENV PREFER_IP_ADDRESS=true
#ENV SERVER_IP=172.18.0.2
ADD ./target/eureka-server-1.0.jar /app.jar

RUN sh -c 'touch /app.jar'
EXPOSE 8761
VOLUME /tmp
ENTRYPOINT ["java"]