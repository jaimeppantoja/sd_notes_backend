# Use a lightweight Java image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Copy the source code and pom.xml
COPY src ./src
COPY pom.xml .

# Make the Maven wrapper executable
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw package -DskipTests

# Expose the port (match Render's dynamic port)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/*.jar"]
