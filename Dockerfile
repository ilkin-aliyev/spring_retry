FROM openjdk

WORKDIR /code/
COPY ./target/spring-retry-0.0.1-SNAPSHOT.jar .

EXPOSE 80

ENTRYPOINT ["java", "-jar", "spring-retry-0.0.1-SNAPSHOT.jar", "--server.port=80"]
