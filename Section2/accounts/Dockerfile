#Start with a base image that has OpenJDK 17 installed

FROM eclipse-temurin:21-jre-alpine

#Information about the who maintains the image
MAINTAINER bhasinsaurav.com
#Add the application's jar file to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Execute the application when the container starts
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
