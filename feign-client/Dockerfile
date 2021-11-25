FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} feign-client.jar
ENTRYPOINT ["java","-jar","/feign-client.jar"]