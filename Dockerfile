# Use a Java base image
FROM openjdk:21

# Set the working directory
WORKDIR /

# Build jar
#RUN mvn clean package

# Copy the application jar to the container
COPY target/ecommerce.jar .
EXPOSE 8080
# Set the environment variables
ENV JAVA_OPTS=""

# Define the command to run the application
CMD ["java", "-jar", "ecommerce.jar"]
