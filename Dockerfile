FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app
COPY . .

RUN apk upgrade && mvn clean install

CMD ["mvn", "spring-boot:run"]
