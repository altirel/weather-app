FROM bellsoft/liberica-openjdk-alpine:17
VOLUME /tmp
COPY build/libs/*SNAPSHOT.jar app.jar
EXPOSE 8080
ENV DATABASE_HOST=postgres
ENV DATABASE_NAME=weather-app
ENV DATABASE_USERNAME=root
ENV DATABASE_PASSWORD=root
ENV OPEN_WEATHER_VERSION=2.5
ENTRYPOINT ["java", "-jar", "/app.jar"]