#!/usr/bin/env bash

# Install java
sudo apt-get update -y
sudo apt install openjdk-11-jdk -y
sudo apt-get install wget unzip -y

# create new system user and group
sudo useradd -m -U -d /opt/tomcat -s /bin/false tomcat

wget https://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.45/bin/apache-tomcat-9.0.45.tar.gz -P /tmp
sudo tar -xf /tmp/apache-tomcat-9.0.45.tar.gz -C /opt/tomcat/
sudo ln -s /opt/tomcat/apache-tomcat-9.0.45 /opt/tomcat/latest
sudo chown -R tomcat: /opt/tomcat
sudo sh -c 'chmod +x /opt/tomcat/latest/bin/*.sh'
sudo cp /vagrant/script/tomcat.service /etc/systemd/system/
sudo systemctl daemon-reload
sudo systemctl enable --now tomcat
sudo ufw allow 8080/tcp
sudo cp /vagrant/script/tomcat-users.xml /opt/tomcat/latest/conf/
sudo cp /vagrant/script/context.xml /opt/tomcat/latest/webapps/host-manager/META-INF/
sudo cp /vagrant/script/context.xml /opt/tomcat/latest/webapps/manager/META-INF/
sudo systemctl restart tomcat