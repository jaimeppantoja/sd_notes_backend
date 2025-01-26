# Use a Java 21 image
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the Maven wrapper and configuration files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code
COPY src ./src

# Make the Maven wrapper executable
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw package -DskipTests

# Expose the app port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/*.jar"]
