# Use an official MySQL image as a parent image to start MySQL locally
FROM mysql:latest

# Set environment variables for MySQL
ENV MYSQL_ROOT_PASSWORD=1000
ENV MYSQL_DATABASE=bob4o-mysql
ENV MYSQL_USER=bob4o
ENV MYSQL_PASSWORD=1000

# Expose the MySQL port
EXPOSE 3306

# Copy the MySQL initialization script to the container
COPY src/main/resources/db/migration/V2_init.sql /docker-entrypoint-initdb.d/

# Use an official OpenJDK image as a parent image for the Java application
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the Java application JAR file to the container
COPY target/casino_api-0.0.1-SNAPSHOT.jar /app/casino-api.jar

# Expose the ports needed by the Java application
EXPOSE 4040

# CMD to start MySQL service and run the Java application
CMD ["sh", "-c", "service mysql start && sleep 10 && java -jar casino-api.jar"]
