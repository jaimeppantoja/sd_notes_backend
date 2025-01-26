# # Use a Java 21 image
# FROM openjdk:21-jdk-slim

# WORKDIR /app

# # Copy the Maven wrapper and configuration files
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .

# # Copy the source code
# COPY src ./src

# # Make the Maven wrapper executable
# RUN chmod +x ./mvnw

# # Run Maven build to generate the JAR file
# RUN ./mvnw clean package -DskipTests

# # Expose the app port
# EXPOSE 8080

# # Run the application
# CMD ["java", "-jar", "target/*.jar"]

# Build stage
FROM openjdk:21-jdk-slim AS build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src ./src
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Run stage
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar 
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]