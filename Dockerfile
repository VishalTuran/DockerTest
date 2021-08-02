FROM ubuntu
RUN su -
RUN apt-get update
RUN apt-get install sudo
RUN sudo apt install maven -y
RUN sudo apt install wget -y
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN sudo apt install ./google-chrome-stable_current_amd64.deb -y
RUN sudo apt-get install openjdk-8-jdk -y
RUN sudo update-java-alternatives --set /usr/lib/jvm/java-1.8.0-openjdk-amd64

ADD . /testproject
WORKDIR /testproject
ENTRYPOINT [ "java","-version"]

# FROM jenkins/jenkins:2.289.3-lts-jdk11
# USER root
# RUN apt-get update && apt-get install -y apt-transport-https \
#        ca-certificates curl gnupg2 \
#        software-properties-common
# RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
# RUN apt-key fingerprint 0EBFCD88
# RUN add-apt-repository \
#        "deb [arch=amd64] https://download.docker.com/linux/debian \
#        $(lsb_release -cs) stable"
# RUN apt-get update && apt-get install -y docker-ce-cli
# USER jenkins
# RUN jenkins-plugin-cli --plugins "blueocean:1.24.7 docker-workflow:1.26"
