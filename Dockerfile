FROM maven:3.8.6-jdk-8
COPY . /home
WORKDIR /home
RUN mvn clean install
ENTRYPOINT ["java","-jar","target/analyzer-0.0.1-SNAPSHOT.jar"]
