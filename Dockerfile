FROM openjdk:8-alpine

RUN mkdir -p /usr/src/app
COPY build/libs/klib.trackr-0.1.0.jar /usr/src/app
WORKDIR /usr/src/app
CMD java -jar klib.trackr-0.1.0.jar