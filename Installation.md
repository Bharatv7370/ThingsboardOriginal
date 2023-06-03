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

        sudo apt-get install maven

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

manage Docker as a non-root user to run tests properly.
