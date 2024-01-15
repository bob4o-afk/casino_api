# Use an official OpenJDK image as a parent image for the Java application
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the Java application JAR file to the container
COPY target/casino_api-0.0.1-SNAPSHOT.jar /app/casino-api.jar

# Install MySQL client
RUN apt-get update && apt-get install -y default-mysql-client && rm -rf /var/lib/apt/lists/*

# Expose the ports needed by the Java application
EXPOSE 4040

# CMD to start MySQL service and run the Java application
CMD service mysql start && sleep 10 && java -jar casino-api.jar
