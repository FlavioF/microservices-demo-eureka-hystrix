#!/bin/sh
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$1 -DCONFIG_SERVER_IP=config -DSERVER_IP=eureka -DPORT=$2 -jar /app.jar