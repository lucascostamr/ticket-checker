FROM maven:3.9.9-eclipse-temurin-23-alpine

WORKDIR /app
COPY . .

RUN apk upgrade && mvn clean install

CMD ["mvn", "spring-boot:run"]<
