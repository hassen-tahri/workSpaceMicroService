FROM openjdk:8-jdk-alpine
EXPOSE 8084
ADD /target/Book-0.0.1-SNAPSHOT.jar Book-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Book-0.0.1-SNAPSHOT.jar"]