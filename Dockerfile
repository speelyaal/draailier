FROM openjdk:11.0.6-jre-slim-buster
VOLUME /tmp
ARG JAR_FILE
ARG SERVICE_VERSION
COPY mappers /cloudMappers
COPY draailier-spring-boot/build/libs/draailier-${SERVICE_VERSION}.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
