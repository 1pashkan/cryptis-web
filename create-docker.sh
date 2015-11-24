#!/bin/sh
mvn clean package
cp src/main/docker/Dockerfile target/
docker build -t ru.cryptis/web target
