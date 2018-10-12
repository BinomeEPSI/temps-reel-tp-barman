FROM openjdk:11-jdk-slim
COPY src/ /usr/src/app
WORKDIR /usr/src/app