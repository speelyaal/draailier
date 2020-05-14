FROM openjdk:11.0.6-jre-slim-buster
VOLUME /tmp
ARG JAR_FILE
COPY mappers /cloudMappers
COPY draailier-spring-boot/build/libs/draailier-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
