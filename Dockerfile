#FROM openjdk:8-jdk
#FROM openjdk:8-jdk-alpine

#ARG JAR_FILE=target/provakubernates-1.0.jar
#COPY target/provakubernates-1.0.jar provakubernates-1.0.jar


#env $JAVA_HOME /usr/lib/jvm

#FROM java:8

#EXPOSE 8080-8080



#JAVA_HOME

#ADD target/provakubernates-1.0.jar  provakubernates-1.0.jar
#COPY target/provakubernates-1.0.jar provakubernates-1.0.jar



#RUN java -jar provakubernates-1.0.jar

#ENTRYPOINT ["java", "-jar", "provakubernates-1.0.jar"]
 


#--------------------------------

FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/provakubernates-1.0.jar

EXPOSE 8080:8080

copy target/ascoltaKafka-1.0.jar  ascoltaKafka-1.0.jar

ENTRYPOINT ["java", "-jar", "provakubernates-1.0.jar"]

