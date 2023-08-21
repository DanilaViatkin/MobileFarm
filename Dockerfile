FROM maven:3.8.3-openjdk-17 as build
COPY src /home/MobileFarm/src
COPY pom.xml /home/MobileFarm
RUN -mvn -f /home/MobileFarm/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/MobileFarm/target/MobileFarm-0.0.1-SNAPSHOT.jar"]