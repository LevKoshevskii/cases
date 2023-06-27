FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY build/libs/cases-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "cases-0.0.1-SNAPSHOT.jar"]