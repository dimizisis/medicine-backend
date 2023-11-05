# Use a base image with Java and a JRE as a parent image
FROM amazoncorretto:21

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container
COPY target/medicine-backend-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
