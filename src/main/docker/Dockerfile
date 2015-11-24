# Thanks https://spring.io/guides/gs/spring-boot-docker/
# http://docs.docker.com/engine/reference/builder/
FROM java:8
VOLUME /tmp
ADD cryptis-web.jar cryptis-web.jar
RUN bash -c 'touch /cryptis-web.jar'
EXPOSE 8080 22
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cryptis-web.jar"]
