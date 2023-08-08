#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src ./src
COPY pom.xml ./
RUN mvn -f ./pom.xml clean package


FROM openjdk:17
ADD ./docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]