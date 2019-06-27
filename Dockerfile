# USAGE:
# docker build -t fluentness
# docker run -it fluentness
# > java -jar target/fluentness-{version}-jar-with-dependencies.jar

FROM openjdk:8

MAINTAINER germede

ENV MAVEN_VERSION 3.6.0
ENV MAVEN_HOME /usr/share/maven

RUN curl -sSL http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
 && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

COPY . /var/www/java

WORKDIR /var/www/java

RUN mvn clean package
