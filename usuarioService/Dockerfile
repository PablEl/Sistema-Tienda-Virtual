FROM openjdk:17-jdk-slim
COPY target/usuario-service.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
