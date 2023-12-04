FROM openjdk:20
EXPOSE 8085
ADD target/Category-1.0.0.jar Category-1.0.0.jar
ENTRYPOINT ["java", "-jar", "Category-1.0.0.jar"]
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:category
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://serviceregistry:8761/eureka/