# Use an existing docker image as a base
FROM openjdk

# Download and install a dependency


# Tell the image what to do when it starts as a container
EXPOSE 8080

ADD ./build/libs/*.jar app.jar

#ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD ["java", "-jar", "/app.jar"]
