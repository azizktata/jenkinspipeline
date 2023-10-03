FROM openjdk:17-jdk-slim
VOLUME /tmp
ADD target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
EXPOSE 8084