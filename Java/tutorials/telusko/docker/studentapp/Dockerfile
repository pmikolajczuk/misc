FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/studentapp.jar /app/studentapp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/studentapp.jar"]

