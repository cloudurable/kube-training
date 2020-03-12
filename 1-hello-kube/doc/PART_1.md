# Deploying Basic Hello World Spring Boot App - Ubuntu

In this guide, you will deploy the Spring Boot hello-world application in an Ubuntu environment.

In this tutorial you need:

* Java
* Spring Boot IDE

#### Install Java - Open JDK - Ubuntu

**Prerequisites**

Before continuing with this tutorial, make sure you are logged in as a user with sudo privileges.

Update the apt package index with:
```sh
$ sudo apt update
```

Install the default Java OpenJDK package with:
```sh
$ sudo apt install default-jdk
```

Verify the installation, by running the following command which will print the Java version:

```sh
$ java -version
```

##### Output
```sh
openjdk version "13.0.2" 2020-01-14
OpenJDK Runtime Environment AdoptOpenJDK (build 13.0.2+8)
```

#### Install Spring Boot IDE (Spring Tool Suite)

You can use your preferred Java IDE like [Eclipse](https://www.eclipse.org/downloads/), [IntelliJ](https://www.jetbrains.com/idea/download/) or other tool. I used the [Spring Tool Suite](https://spring.io/tools).

I will show you how to install the Spring Tool Suite. If you already have a IDE go to next step.

Enter in the Downloads folder
```sh
cd Downloads
```

Create a sts folder.
```sh
$ mkdir sts
```

Enter in the folder created
```sh
$ cd sts
```
##### Output
```sh
~/Downloads/java $
```

Download Spring Tool Suite
```sh
$ wget https://download.springsource.com/release/STS4/4.5.1.RELEASE/dist/e4.14/spring-tool-suite-4-4.5.1.RELEASE-e4.14.0-linux.gtk.x86_64.tar.gz
```
This file has approximately 350M
##### Output
```sh
--2020-03-11 11:24:44--  https://download.java.net/java/GA/jdk13.0.2/d4173c853231432d94f001e99d882ca7/8/GPL/openjdk-13.0.2_linux-x64_bin.tar.gz
Resolving download.java.net (download.java.net)... 23.1.244.118
Connecting to download.java.net (download.java.net)|23.1.244.118|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 195812001 (187M) [application/x-gzip]
Saving to: ‘openjdk-13.0.2_linux-x64_bin.tar.gz’

openjdk-13.0.2_linu 100%[===================>] 186.74M  9.10MB/s    in 13s     

2020-03-11 11:24:58 (14.2 MB/s) - ‘openjdk-13.0.2_linux-x64_bin.tar.gz’ saved [195812001/195812001]
```

You can check if the file was downloaded typing the ls command
```sh
$ ls
```
##### Output
```sh
spring-tool-suite-4-4.5.1.RELEASE-e4.14.0-linux.gtk.x86_64.tar.gz
```
Extracting Spring Boot Tool
```sh
$ tar xvf spring*.tar.gz
```
You can see that a new folder was created
```sh
$ ls -la
```
##### Output
```sh
total 384296
drwxrwxr-x 3 robert robert      4096 Mar 11 13:44 .
drwxr-xr-x 3 robert robert      4096 Mar 11 13:24 ..
-rw-rw-r-- 1 robert robert 393504116 Jan 21 05:54 spring-tool-suite-4-4.5.1.RELEASE-e4.14.0-linux.gtk.x86_64.tar.gz
drwxr-xr-x 9 robert robert      4096 Jan 21 05:41 sts-4.5.1.RELEASE
```
To start the Spring Boot Tool you need to type the command
```sh
$ ./sts-4.5.1.RELEASE/SpringToolSuite4
```
##### Output
![image](https://user-images.githubusercontent.com/32839242/76464378-7b238a80-63a2-11ea-954d-bae28aaadc80.png)

Great! It worked!

#### Creating Hello World App!

Create the initializer!

Go to the website [start.spring.io](https://start.spring.io/)
![image](https://user-images.githubusercontent.com/32839242/76467414-d48db880-63a6-11ea-97d0-5af5a7de7047.png)

Select **Gradle** Project, **Java** Language and version **2.2.5** to Spring Boot
![image](https://user-images.githubusercontent.com/32839242/76467961-0b180300-63a8-11ea-9ae1-6bbf12a0ed0a.png)

In Project Metadata:
```
Group: com.firstproject
Artifact: HelloWorld
Options
Name: HelloWorld
Description: HelloWorld project for Spring Boot
Package name: com.firstproject.HelloWorld
Packaging: Jar
Java: 8
```
![image](https://user-images.githubusercontent.com/32839242/76474661-98178800-63b9-11ea-9919-38a1b886b02f.png)

In Dependencies Type **web** in search them select **Spring Web**  
You will see Spring Web in the selected dependencies
![image](https://user-images.githubusercontent.com/32839242/76468561-76aea000-63a9-11ea-985f-013bf524bfc2.png)

Now click in the button **Generate** to download your initializator.

Open a terminal and create a new folder
```sh
$ mkdir firstproject
```
Copy the initializator downloaded to the new folder
```sh
$ mv Downloads/HelloWorld.zip firstproject/
```
Check if the file was copied
```sh
$ ls firstproject/
```
##### Output
```sh
HelloWorld.zip
```
Enter in the folder firstproject
```sh
$ cd firstproject/
```
You need to extract the file
```sh
$ unzip HelloWorld.zip
```
##### Output
```sh
Archive:  HelloWorld.zip
   creating: HelloWorld/
  inflating: HelloWorld/settings.gradle  
   creating: HelloWorld/gradle/
   creating: HelloWorld/gradle/wrapper/
  inflating: HelloWorld/gradle/wrapper/gradle-wrapper.properties  
  inflating: HelloWorld/gradle/wrapper/gradle-wrapper.jar  
  inflating: HelloWorld/gradlew       
  inflating: HelloWorld/gradlew.bat   
  inflating: HelloWorld/build.gradle  
   creating: HelloWorld/src/
   creating: HelloWorld/src/main/
   creating: HelloWorld/src/main/java/
   creating: HelloWorld/src/main/java/com/
   creating: HelloWorld/src/main/java/com/firstproject/
   creating: HelloWorld/src/main/java/com/firstproject/HelloWord/
  inflating: HelloWorld/src/main/java/com/firstproject/HelloWord/HelloWordApplication.java  
   creating: HelloWorld/src/main/resources/
  inflating: HelloWorld/src/main/resources/application.properties  
   creating: HelloWorld/src/main/resources/templates/
   creating: HelloWorld/src/main/resources/static/
   creating: HelloWorld/src/test/
   creating: HelloWorld/src/test/java/
   creating: HelloWorld/src/test/java/com/
   creating: HelloWorld/src/test/java/com/firstproject/
   creating: HelloWorld/src/test/java/com/firstproject/HelloWord/
  inflating: HelloWorld/src/test/java/com/firstproject/HelloWord/HelloWordApplicationTests.java  
  inflating: HelloWorld/HELP.md       
  inflating: HelloWorld/.gitignore
```

You need to import the initializator in the IDE
Open your IDE and import the project
In Spring Tool Suite go to **File** and click **Import...**
![image](https://user-images.githubusercontent.com/32839242/76472897-212bc080-63b4-11ea-9dff-fb66bb7b34d8.png)

Select **Existing Gradle Project** and click **Next**
![image](https://user-images.githubusercontent.com/32839242/76472987-63550200-63b4-11ea-8fd0-7a451c46601e.png)

Click **Next** if you show this screen
![image](https://user-images.githubusercontent.com/32839242/76473159-e413fe00-63b4-11ea-9bda-b10aed97af2c.png)

Browse and find the folder HelloWorld
![image](https://user-images.githubusercontent.com/32839242/76474854-3c99ca00-63ba-11ea-9223-c570e66186d4.png)

Click in Finish and wait to finish
![image](https://user-images.githubusercontent.com/32839242/76473713-9ef0cb80-63b6-11ea-8a99-34ef66ec3e0e.png)

Let`s create your Java Controler
In your main app you will need to create a new class
![image](https://user-images.githubusercontent.com/32839242/76474123-dca22400-63b7-11ea-9e51-162f992f6ab2.png)

The name is HelloWorldController
![image](https://user-images.githubusercontent.com/32839242/76474971-a4501500-63ba-11ea-8469-d728afe7325b.png)

![image](https://user-images.githubusercontent.com/32839242/76477975-47f1f300-63c4-11ea-99bf-e59b986d2b4a.png)

HelloWorldController.java
```java
package com.firstproject.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/", produces="text/html")
	public String index() {
		return "<html><body><H1>Hello World</H1></body></html>";
	}

}
```
Gradle build

```sh
$ gradle build
```
##### Output
```sh
> Task :test
2020-03-11 18:19:16.699  INFO 4493 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'

BUILD SUCCESSFUL in 9s
5 actionable tasks: 5 executed
```
Now, you need to run this command to test your Hello World!
```sh
![image](https://user-images.githubusercontent.com/32839242/76550269-18d49380-644f-11ea-9eb4-142525538b55.png)
```
##### Output
```sh
> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.5.RELEASE)

2020-03-12 10:48:23.019  INFO 16850 --- [           main] c.f.HelloWorld.HelloWorldApplication     : Starting HelloWorldApplication on rick-linux with PID 16850 (/home/robert/firstproject/HelloWorld/build/classes/java/main started by robert in /home/robert/firstproject/HelloWorld)
2020-03-12 10:48:23.022  INFO 16850 --- [           main] c.f.HelloWorld.HelloWorldApplication     : No active profile set, falling back to default profiles: default
2020-03-12 10:48:23.757  INFO 16850 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-03-12 10:48:23.768  INFO 16850 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-03-12 10:48:23.768  INFO 16850 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.31]
2020-03-12 10:48:23.816  INFO 16850 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-03-12 10:48:23.816  INFO 16850 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 742 ms
2020-03-12 10:48:23.934  INFO 16850 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-03-12 10:48:24.064  INFO 16850 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-03-12 10:48:24.067  INFO 16850 --- [           main] c.f.HelloWorld.HelloWorldApplication     : Started HelloWorldApplication in 1.346 seconds (JVM running for 1.566)
2020-03-12 10:48:34.141  INFO 16850 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-03-12 10:48:34.141  INFO 16850 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-03-12 10:48:34.145  INFO 16850 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 4 ms
<=========----> 75% EXECUTING [2m 32s]
> :bootRun
```

Open in Browser
Type ```http://localhost:8080``` in your browser.
![image](https://user-images.githubusercontent.com/32839242/76550269-18d49380-644f-11ea-9eb4-142525538b55.png)
