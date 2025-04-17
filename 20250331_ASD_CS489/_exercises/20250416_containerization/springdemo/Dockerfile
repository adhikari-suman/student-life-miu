FROM amazoncorretto:21-alpine

WORKDIR /app

COPY ./build/libs/myapp-1.0.1.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]