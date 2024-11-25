FROM openjdk:21-jdk-slim
COPY target/*.jar /app/sample.jar
COPY src/main/resources/application.properties /app/application.properties
WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "sample.jar"]







