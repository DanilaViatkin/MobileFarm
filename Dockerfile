FROM maven:3.8.2-openjdk-17
WORKDIR /MobielFarm
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run

#FROM openjdk:17-oracle
#VOLUME /MobileFarm
#ADD target/MobileFarm-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar","/app.jar"]