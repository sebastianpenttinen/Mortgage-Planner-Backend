FROM openjdk:8-jdk-alpine
COPY MortgagePlanner-0.0.1.jar  app.jar
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
ENTRYPOINT ["java","-jar","/app.jar"]

