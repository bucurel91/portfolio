#FROM jenkins/jenkins:2.332.3-jdk11
#USER root
#RUN apt-get update && apt-get install -y lsb-release
#RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
#  https://download.docker.com/linux/debian/gpg
#RUN echo "deb [arch=$(dpkg --print-architecture) \
#  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
#  https://download.docker.com/linux/debian \
#  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
#RUN apt-get update && apt-get install -y docker-ce-cli
#USER jenkins
#RUN jenkins-plugin-cli --plugins "blueocean:1.25.3 docker-workflow:1.28" \

FROM maven:3-jdk-8-alpine AS build

WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean install -Dskiptests

FROM openjdk:8-jdk-alpine
COPY --from=build /opt/app/target/*.jar app.jar

ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "-Xmx1024M", "-Dserver.port=${PORT}", "app.jar"]

