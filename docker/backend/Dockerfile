FROM openjdk:8u131

RUN mkdir -p /opt/test-fullstack/
RUN mkdir -p /etc/test-fullstack/

EXPOSE 8080

COPY application.yml /etc/test-fullstack/
COPY dist/backend.jar /opt/test-fullstack

ENTRYPOINT java -jar /opt/test-fullstack/backend.jar --spring.config.location=classpath:/application.yml,file:///etc/test-fullstack/application.yml