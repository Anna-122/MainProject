FROM maven:3.6.3 AS build
COPY . /usr/app
WORKDIR /usr/app
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11
COPY --from=build /usr/app/target/hibernate-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/hibernate.jar
ENTRYPOINT ["java","-jar","/usr/app/hibernate.jar"]
