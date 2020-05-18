FROM openjdk:14-alpine
COPY build/libs/mn-java-jpa-bug-*-all.jar mn-java-jpa-bug.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "mn-java-jpa-bug.jar"]