FROM openjdk:17
EXPOSE 8080
ADD target/restaurant.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]