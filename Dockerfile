FROM alpine:3.14
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY target/desafio-0.0.1-SNAPSHOT.jar desafio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["%JAVA_HOME%\bin\java","-jar","desafio-0.0.1-SNAPSHOT.jar"]