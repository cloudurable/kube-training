# Running App Hello World in Docker

### Installing Docker

To run this tutorial you will need to install the Docker. The installation package available in the official Ubuntu repository may not be the latest version. Follow the steps to ensure that you get the latest Docker version.

To do that, we’ll add a new package source, and then install the package.

Update your existing list of packages:
```sh
$ sudo apt update
```

You need to install a few prerequisite packages which let **apt** use packages over HTTPS
```sh
$ sudo apt install apt-transport-https ca-certificates software-properties-common
```

Now you need to add the **GPG** key for the official Docker repository to ensure the downloads are valid:
```sh
$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```
##### Output  
```sh
OK
```

You need to add a new package repository (docker) to APT sources
```sh
$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"
```
##### Output
```sh
Get:1 https://download.docker.com/linux/ubuntu bionic InRelease [64.4 kB]
Hit:2 http://us.archive.ubuntu.com/ubuntu bionic InRelease
Hit:3 http://security.ubuntu.com/ubuntu bionic-security InRelease
Hit:4 http://us.archive.ubuntu.com/ubuntu bionic-updates InRelease
Hit:5 http://us.archive.ubuntu.com/ubuntu bionic-backports InRelease
Get:6 https://download.docker.com/linux/ubuntu bionic/stable amd64 Packages [11.0 kB]
Fetched 75.5 kB in 1s (115 kB/s)
Reading package lists... Done
```

Update the package database
```sh
$ sudo apt update
```

Install Docker  
 ```sh
sudo apt install docker-ce
 ```

###Testing docker installation

Before we try to create our docker image we need to test if the docker is working. To do that I run the command:
```sh
$ docker version
```
##### Output:
```sh
$ docker version
Client:
 Version:           18.09.7
 API version:       1.39
 Go version:        go1.10.4
 Git commit:        2d0083d
 Built:             Fri Aug 16 14:19:38 2019
 OS/Arch:           linux/amd64
 Experimental:      false
Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock:  
Get http://%2Fvar%2Frun%2Fdocker.sock/v1.39/version: dial unix /var/run/docker.sock: connect: permission denied
robert@rick-linux ~/github/kube-training $
```
Houston we have a problem. Let's see how fixed it:  
*If you are able to see the server description, jump these steps.*

1 - Create a group **docker**:
```sh
$ sudo groupadd docker
```

2 - Add your user to group created (**docker**):
```sh
$ sudo usermod -aG docker ${USER}
```  
3 - You will need to log out and log back in so that your group membership is reevaluated.

Trying again:  
```sh
$ docker version
Client:
 Version:           18.09.7
 API version:       1.39
 Go version:        go1.10.4
 Git commit:        2d0083d
 Built:             Fri Aug 16 14:19:38 2019
 OS/Arch:           linux/amd64
 Experimental:      false

Server:
 Engine:
  Version:          18.09.7
  API version:      1.39 (minimum version 1.12)
  Go version:       go1.10.4
  Git commit:       2d0083d
  Built:            Thu Aug 15 15:12:41 2019
  OS/Arch:          linux/amd64
  Experimental:     false
```
**Works fine!!**  

Finally!!, I can test my environment!  

```sh
$ docker run -it --rm ubuntu
```
>-it: used to interact with the container using Terminal.  
>-rm: tells Docker to remove the container once we exit the Terminal session.  
>-ubuntu: Docker will create a container that runs Ubuntu.

##### Output  
```sh
$ docker run -it --rm ubuntu
Unable to find image 'ubuntu:latest' locally
latest: Pulling from library/ubuntu
423ae2b273f4: Pull complete
de83a2304fa1: Pull complete
f9a83bce3af0: Pull complete
b6b53be908de: Pull complete
Digest: sha256:04d48df82c938587820d7b6006f5071dbbffceb7ca01d2814f81857c631d44df
Status: Downloaded newer image for ubuntu:latest
root@95b02cbc92d8:/# exit
exit
robert@rick-linux ~/github/kube-training/first-project/docker $ docker run -it --rm ubuntu
root@bccc9f2049ca:/#
```
Now we can stop to play and return to our project:

##### Be careful with this command, it will delete all your running Pods.

```sh
$ docker rm -f $(docker ps -aq)
```

>Stops and removes the containers whose container IDs are specified to the command.  

### Build our .jar file for project Hello World
>It needs to be executed in the project root directory
```sh
$ cd ~/firstproject/HelloWorld/
```
> "~" represents your home folder

Build your HelloWorld application

```sh
$ ./gradlew build
```  
##### Output  
```sh
$ ./gradlew build

> Task :test
2020-03-06 15:49:36.262  INFO 12396 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  
: Shutting down ExecutorService 'applicationTaskExecutor'

BUILD SUCCESSFUL in 10s
5 actionable tasks: 2 executed, 3 up-to-date
```
**Important Note:**  
*The jar file was create in the **/build/libs/** folder*  
```sh
$ ls build/libs/
hello-world-0.0.1-SNAPSHOT.jar
```
### Dockerfile  
The Dockerfile is used to docker builds your own image.
>Use your text editor(Nano, Vi, ...) and create the "Dockerfile". It needs to be created in your root project directory  

Dockerfile
```
# Use an existing docker image as a base
FROM openjdk

# Tell the image what to do when it starts as a container

# ADD command is used to copy files/directories into a Docker image.
# We are copying our jar file to the container
ADD ./build/libs/*.jar app.jar

#CMD command is used to execute a command inside the container
# This command execute our Hello Word App
CMD ["java", "-jar", "/app.jar"]
```
### Build our image
To build our image we will use the command:  
```sh
$ docker build -t hw .
```  
> This command build our image with the parameter -t that tags the image (hw).  
##### Output
```sh
$ docker build -t hw .
Sending build context to Docker daemon  30.31MB
Step 1/3 : FROM openjdk
 ---> 6adc576f6a58
Step 2/3 : ADD ./build/libs/*.jar app.jar
 ---> 786cf749b006
Step 3/3 : CMD ["java", "-jar", "/app.jar"]
 ---> Running in ecb49e7acb76
Removing intermediate container ecb49e7acb76
 ---> 7a1dc176c974
Successfully built 7a1dc176c974
Successfully tagged hw:latest
```
### Run our image  
```sh
$ docker run hw
```  
##### Output
```sh
$ docker run hw

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.5.RELEASE)

2020-03-07 02:37:11.202  INFO 1 --- [           main] c.c.helloworld.HelloWorldApplication     : Starting HelloWorldApplication on 62d5f63f5e3c with PID 1 (/app.jar started by root in /)
2020-03-07 02:37:11.206  INFO 1 --- [           main] c.c.helloworld.HelloWorldApplication     : No active profile set, falling back to default profiles: default
2020-03-07 02:37:12.133  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-03-07 02:37:12.141  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-03-07 02:37:12.142  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.31]
2020-03-07 02:37:12.195  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-03-07 02:37:12.195  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 937 ms
2020-03-07 02:37:12.457  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-03-07 02:37:12.596  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2020-03-07 02:37:12.637  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-03-07 02:37:12.640  INFO 1 --- [           main] c.c.helloworld.HelloWorldApplication     : Started HelloWorldApplication in 1.806 seconds (JVM running for 2.13)
```
It seems that is **working fine!**  
Let's open another terminal to verify it!  
```sh
$ docker ps
```  
##### Output
```sh
$ docker ps
CONTAINER ID        IMAGE               COMMAND                CREATED             STATUS              PORTS               NAMES
62d5f63f5e3c        hw                  "java -jar /app.jar"   4 minutes ago       Up 4 minutes                            gifted_swirles
```
> The command show us that the image is running, yes we did it!  

### Now is time to test our app Hello World!

In the same terminal that used to command docker ps type:   
```sh
$ docker exec -it <container name> /bin/bash
```  
> This command is used to connect in a running container (exec) with interaction (it)  
> We need the container name (last column of docker ps command)  
> And to get a shell in the container (/bin/bash)  
##### Output
```sh
$ docker exec -it gifted_swirles /bin/bash
bash-4.2#
```  
Now we can test our app Hello World!
```sh
# curl localhost:8080
```
##### Output
```sh
bash-4.2# curl localhost:8080
<html><body><H1>Hello World</H1></body></html>bash-4.2#
```  
**Good, it's working!**  

Type ```exit``` to exit the container

Return to the previous terminal and stop the container.  
Press **Ctrl + c**

### Now it is time to expose the container to outside!
First, let's change our Dockerfile, adding line:
```
EXPOSE 8080
```
*Dockerfile
```
# Use an existing docker image as a base
FROM openjdk

# Tell the image what to do when it starts as a container

#Expose the 8080 port to external access.
EXPOSE 8080

# ADD command is used to copy files/directories into a Docker image.
# We are copying our jar file to the container
ADD ./build/libs/*.jar app.jar

#CMD command is used to execute a command inside the container
# This command execute our Hello Word App
CMD ["java", "-jar", "/app.jar"]
```
Save the file then build your image again  
>Don't forget to stop your container

```sh
docker build -t hw .
```  
##### Output
```sh
robert@rick-linux ~/github/kube-training/hello-kube/services/hello-world $ docker build -t hw .
Sending build context to Docker daemon  30.31MB
Step 1/4 : FROM openjdk
 ---> 6adc576f6a58
Step 2/4 : EXPOSE 8080
 ---> Using cache
 ---> e924d4d8ef1d
Step 3/4 : ADD ./build/libs/*.jar app.jar
 ---> Using cache
 ---> a938b67080b5
Step 4/4 : CMD ["java", "-jar", "/app.jar"]
 ---> Running in 2b1f020d7173
Removing intermediate container 2b1f020d7173
 ---> 18054b26c10c
Successfully built 18054b26c10c
Successfully tagged hw:latest
```
Let's run our new container:
```sh
$ docker run hw
```
Let's see if the container is running. Open another terminal:
```sh
$ docker ps
```
##### Output
```sh
$ docker ps
CONTAINER ID        IMAGE               COMMAND                CREATED             STATUS              PORTS               NAMES
4efa3cf7f105        hw                  "java -jar /app.jar"   3 minutes ago       Up 3 minutes        8080/tcp            suspicious_pike
```  
> Look, the column Ports show us the value 8080/tcp.  

But, what is the container Ip address.
Use the command:
```sh
$ docker inspect <CONTAINER_ID>
```
##### Output
```sh
$ docker inspect 4efa3cf7f105
[
    {
        "Id": "4efa3cf7f105184b79c9b5a5d958d5f8f41847795022b4034bbeb3b9a274304b",
        "Created": "2020-03-07T03:27:52.519877158Z",
        "Path": "java",
        "Args": [
            "-jar",
            "/app.jar"
        ],
        ...
            "Networks": {
                "bridge": {
                    "IPAMConfig": null,
                    "Links": null,
                    "Aliases": null,
                    "NetworkID": "f7b1196ed191da614850775522dbec983612abf8c53f3043600e5c985264adde",
                    "EndpointID": "7d98722ac9de147edcff1dd7bbf0352aab2d0f74f88c3583ba0583fa93ffaf73",
                    "Gateway": "172.17.0.1",
                    "IPAddress": "172.17.0.2",
                    "IPPrefixLen": 16,
                    "IPv6Gateway": "",
                    "GlobalIPv6Address": "",
                    "GlobalIPv6PrefixLen": 0,
                    "MacAddress": "02:42:ac:11:00:02",
                    "DriverOpts": null
                }
            }
        }
    }
]
```
> This time I used 4efa3cf7f105 (CONTAINER_ID)  
> See the IP Address - "IPAddress": "172.17.0.2"

Testing application:  
```sh
$ curl 172.17.0.2:8080
```
##### Output
```console
$ curl 172.17.0.2:8080
<html><body><H1>Hello World</H1></body></html>
```
Open in Browser:
![image](https://user-images.githubusercontent.com/32839242/76137202-dfcf9580-5fee-11ea-8983-5852d2935e33.png)
