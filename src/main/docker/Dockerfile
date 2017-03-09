# Thanks https://spring.io/guides/gs/spring-boot-docker/
# http://docs.docker.com/engine/reference/builder/
FROM java:8
VOLUME /tmp
ADD web-1.0.0.jar cryptis-web.jar
RUN bash -c 'touch /cryptis-web.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Xmx64m -Djava.security.egd=file:/dev/./urandom","-jar","/cryptis-web.jar"]
