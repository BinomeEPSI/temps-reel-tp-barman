FROM openjdk:11-jdk-slim
COPY src /usr/src/app/src
WORKDIR /usr/src/app/src

RUN javac -d /usr/src/app/bin fr/epsi/binome/*.java
CMD java -cp /usr/src/app/bin fr.epsi.binome.Program