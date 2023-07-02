FROM openjdk:17
ARG JAR_FILE=target/*.jar
EXPOSE 8080 5005
COPY ${JAR_FILE} invoicesystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","/invoicesystem-0.0.1-SNAPSHOT.jar"]

