FROM openjdk:21-jdk-slim
WORKDIR /outbreak
COPY /target/outbreakAI-0.0.1-SNAPSHOT.jar outbreak.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "outbreak.jar"]
