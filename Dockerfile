FROM java:8

EXPOSE 8090

ADD blog-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c'touch /app.jar'

ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=pro"]
#VOLUME /tmp
#COPY *.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=pro"]