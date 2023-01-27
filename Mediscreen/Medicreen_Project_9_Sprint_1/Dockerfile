FROM maven:3.6.1-jdk-11-slim

ADD target/P9JB-0.0.1-SNAPSHOT.jar /patient.jar

ENTRYPOINT ["java","-jar","/patient.jar"]
