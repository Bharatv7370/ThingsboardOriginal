![Logo](https://elansoltech.com/wp-content/uploads/2023/02/Elansol-300x92.png)

## Docker IMAGE Build - Linux

This guide will help you to download and build ThingsBoard from sources

## Authors

- [Elansol Technologies](https://www.elansoltech.com)

## Pre Requisites

Required tools

This section contains installation instructions for build tools.

-Java
 ThingsBoard is build using Java 11. You can use [follow instruction](https://thingsboard.io/docs/user-guide/install/ubuntu/) to install Java 11.

-Maven
ThingsBoard build requires Maven 3.1.0+.

    $ sudo apt-get install maven

Please note that maven installation may set Java 7 as a default JVM on certain Linux machines. Use java installation instructions to fix this.
    
## Installation

You can clone source code of the project from the [official github repo](https://github.com/Bharatv7370/ThingsboardOriginal.git)

    # checkout latest release branch
    git clone https://github.com/Bharatv7370/ThingsboardOriginal.git
    cd thingsboard

Build

Run the following command from the thingsboard folder to build the project:

    mvn clean install -DskipTests

Result Success Build

Make sure that [Docker Engine](https://docs.docker.com/engine/install/) is installed or follow instructions.

Install Docker Engine

Update the apt package index:

    sudo apt-get update

Install Docker Engine, containerd, and Docker Compose.

    sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin


Set up the repository

Update the apt package index and install packages to allow apt to use a repository over HTTPS:

    sudo apt-get update
    sudo apt-get install ca-certificates curl gnupg

Add Docker’s official GPG key:

    sudo install -m 0755 -d /etc/apt/keyrings
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
    sudo chmod a+r /etc/apt/keyrings/docker.gpg

Use the following command to set up the repository:

    echo \
    "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
    "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
    sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

**manage Docker as a non-root user to run tests properly**

Create the docker group.
 
    sudo groupadd docker

Add your user to the docker group.

    sudo usermod -aG docker $USER

Log out and log back in so that your group membership is re-evaluated.

    If you’re running Linux in a virtual machine, it may be necessary to restart the virtual machine for changes to take effect.

You can also run the following command to activate the changes to groups:

    newgrp docker

Verify that you can run docker commands without sudo.

    $ docker run hello-world

This command downloads a test image and runs it in a container. When the container runs, it prints a message and exits.

Once Docker is Engine is Installed & managed as a non-root user.

    mvn clean install -DskipTests -Ddockerfile.skip=false
    
    
**Create docker compose file for ThingsBoard queue service**

    nano docker-compose.yml

copy the following lines to the newly open editor file:

    version: '3.0'
     services:
     mytb:
     restart: always
     image: "thingsboard/tb-postgres"
     ports:
       - "8080:9090"
       - "1883:1883"
       - "7070:7070"
       - "5683-5688:5683-5688/udp"
     environment:
       TB_QUEUE_TYPE: in-memory
     volumes:
       - ~/.mytb-data:/data
       - ~/.mytb-logs:/var/log/thingsboard

PORT's Explanation (No need to take any action):

    8080:9090 - connect local port 8080 to exposed internal HTTP port 9090
    1883:1883 - connect local port 1883 to exposed internal MQTT port 1883
    7070:7070 - connect local port 7070 to exposed internal Edge RPC port 7070
    5683-5688:5683-5688/udp - connect local UDP ports 5683-5688 to exposed internal COAP and LwM2M ports
    ~/.mytb-data:/data - mounts the host’s dir ~/.mytb-data to ThingsBoard DataBase data directory
    ~/.mytb-logs:/var/log/thingsboard - mounts the host’s dir ~/.mytb-logs to ThingsBoard logs directory
    mytb - friendly local name of this machine
    restart: always - automatically start ThingsBoard in case of system reboot and restart in case of failure.
    image: thingsboard/tb-postgres - docker image, can be also thingsboard/tb-cassandra or thingsboard/tb

For Saving the *.yml File execue the following Commands

    Press "CTRL + O"
    Once you see the file name as docker-compose.yml after pressing the above keys
    Press "Enter"
    Press "CTRL + X"

Run following commands, before starting docker container(s), to create folders for storing data and logs. 
These commands additionally will change owner of newly created folders to docker container user. 
To do this (to change user) chown command is used, and this command requires sudo permissions (command will request password for a sudo access):

    mkdir -p ~/.mytb-data && sudo chown -R 799:799 ~/.mytb-data
    mkdir -p ~/.mytb-logs && sudo chown -R 799:799 ~/.mytb-logs

NOTE: Replace directory ~/.mytb-data and ~/.mytb-logs with directories you’re planning to use in docker-compose.yml.

Set the terminal in the directory which contains the docker-compose.yml file and execute the following commands to up this docker compose directly:

    docker compose up -d
    docker compose logs -f mytb
 
 **Wait for while once you see the image running in Log File**
 
After executing this command you can open http://{your-host-ip}:8080 in your browser (for ex. http://localhost:8080). You should see ThingsBoard login page. Use the following default credentials:

    System Administrator: sysadmin@thingsboard.org / sysadmin
    Tenant Administrator: tenant@thingsboard.org / tenant
    Customer User: customer@thingsboard.org / customer

You can always change passwords for each account in account profile page.
