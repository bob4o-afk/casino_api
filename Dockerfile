# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/casino_api-0.0.1-SNAPSHOT.jar /app/casino-api.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run application when the container launches
CMD ["java", "-jar", "casino-api.jar"]
