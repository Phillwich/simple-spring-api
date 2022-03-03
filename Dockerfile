FROM maven:3.8.4-openjdk-17 AS MAVEN_BUILD

ENV MYSQL_DB_IP_ADDRESS=$MYSQL_DB_IP_ADDRESS
ENV MYSQL_USER=$MYSQL_USER
ENV MYSQL_DB_PASSWORD=$MYSQL_DB_PASSWORD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:17

WORKDIR /app
EXPOSE 8080

COPY --from=MAVEN_BUILD /build/target/bootcamp.jar /app/
ENTRYPOINT ["java", "-jar", "bootcamp.jar"]