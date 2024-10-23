FROM maven:3-eclipse-temurin-23 AS build
COPY ./ /home/app
RUN cd /home/app && ./gradlew clean package -Dmaven.test.skip=true
FROM eclipse-temurin:23-alpine
COPY --from=build /home/app/target/spring-practice-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/demo.jar"]