FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD /target/client-0.0.1-SNAPSHOT.jar client-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "client-0.0.1-SNAPSHOT.jar"]