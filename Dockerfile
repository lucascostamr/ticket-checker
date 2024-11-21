FROM maven:3.9.9-eclipse-temurin-23-alpine

WORKDIR /app
COPY . .

RUN apk upgrade && mvn clean install -DskipTests

CMD ["java", "-jar target/ticket-0.0.1-SNAPSHOT.jar"]
