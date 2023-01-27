FROM maven:3.6.1-jdk-11-slim

ADD target/mediscreen_P9_JB_Sprint_3-0.0.1-SNAPSHOT.jar patientrapport.jar

ENTRYPOINT ["java","-jar","/patientrapport.jar"]