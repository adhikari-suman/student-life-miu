FROM amazoncorretto:24-alpine

WORKDIR /app

COPY ./build/libs/myapp-1.0.1.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]