FROM openjdk:8-alpine
EXPOSE 8080
ARG JAR_FILE=target
COPY target/demo-0.0.1-SNAPSHOT.jar/ /tmp
WORKDIR /tmp
CMD java -jar /tmp/demo-0.0.1-SNAPSHOT.jar