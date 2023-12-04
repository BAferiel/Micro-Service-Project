FROM openjdk:17
MAINTAINER microserviceproject
ARG JAR_FILE=target*/.jar
EXPOSE 8761
ADD ./target/EurekaServer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]