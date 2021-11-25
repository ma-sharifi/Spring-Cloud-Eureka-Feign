FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-client.jar
ENTRYPOINT ["java","-jar","/ureka-client.jar"]