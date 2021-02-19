#!/bin/bash
./mvnw clean package -DskipTests
cp target/PollService-0.0.1-SNAPSHOT.jar src/main/docker

cd src/main/docker || exit
sudo docker-compose down
sudo docker rmi docker-spring-boot-postgres:latest
sudo docker-compose up