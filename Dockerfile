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

# ADD . /testproject
# WORKDIR /testproject
ENTRYPOINT [ "java","-version"]
