FROM openjdk:17-alpine
VOLUME /tmp
ADD target/Gestion*.jar /app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
