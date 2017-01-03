#
# Config Server Dockerfile
#
FROM java:openjdk-8-jdk-alpine

MAINTAINER Pras Biswas

# Add OpenSSH
RUN apk update && apk add openssh

# Add directly the jar
ENV SPRING_PROFILES=dev
ADD ./target/config-server-1.0.jar /app.jar

RUN sh -c 'touch /app.jar'
EXPOSE 8888
VOLUME /tmp
ENTRYPOINT ["java"]