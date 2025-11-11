# Use official OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Maintainer info
LABEL authors="Aniket Chavan"
LABEL maintainer="eazybytes.com"

# Add the application JAR to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
