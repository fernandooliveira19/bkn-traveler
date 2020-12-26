FROM openjdk:11
VOLUME /tmp
ADD ./target/bkn-traveler-0.0.1-SNAPSHOT.jar bkn-traveler.jar
ENTRYPOINT ["java","-jar","/bkn-traveler.jar"]
