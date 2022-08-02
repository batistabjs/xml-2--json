FROM openjdk:17-alpine

EXPOSE 9016

ADD /src/main/resources/application.properties application.properties
ADD /target/integrador-0.0.1.jar integrador-0.0.1.jar

CMD java -jar integrador-0.0.1.jar
