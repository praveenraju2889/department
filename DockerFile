# Use an official OpenJDK 17 runtime as a parent image
FROM eclipse-temurin:17
# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/department-1.1.jar /app/

# Expose the port the app runs on
EXPOSE 8080

# Define environment variable
ENV JAVA_OPTS=""

# Run the JAR file
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar department-1.1.jar"]