FROM maven:latest
WORKDIR /home/
EXPOSE 8090
COPY target/mave-project-0.0.1-SNAPSHOT.jar /home/
CMD ["java -jar target/mave-project-0.0.1-SNAPSHOT.jar"]