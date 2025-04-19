FROM amazoncorretto:21-alpine
LABEL authors="bright"

WORKDIR /app

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]