# kube-training
Kubernetes Training 


## Outlines 

* Core Concepts
	* uServices
		* Intro
			* Definition
				
				A microservice is essentially an autonomous software component that is independently upgradeable and scalable.
				
			* Why Microservices?
				
				With microservices, your code is broken into independent services that run as separate processes. Output from one service is used as an input to another in an orchestration of independent, communicating services. Microservices is especially useful for businesses that do not have a pre-set idea of the array of devices its applications will support. By being device- and platform-agnostic, microservices enables businesses to develop applications that provide consistent user experiences across a range of platforms, spanning the web, mobile, IoT, wearables and fitness tracker environments.
		
			* Scale and Distribution
			
				With uServices you can scale and distribute your application horizontally, only in the necessary services and not on your entire application, making it more intelligent and efficient in terms of performance and costs. Currently, cloud structures and uServices have Autoscaling functionality, which can increase the number of services when demand is high and the number of instances decreases when there is no demand, helping you in reducing costs.
				
		
		* Container Orchestrations with Kubernetes
		
	    		* Docker containers
				What is a container?
				
					A container is a standard unit of software that packages up code and all its dependencies so the application runs quickly and reliably from one computing environment to another
				
				Why use Docker?
				
					Docker makes really easy to install and run new software without worrying about setup or dependencies.
					
				What is Docker?
					
					Docker is a platform or ecosystem around creating and running containers. A Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings.
					
					
	    		* Container orchestration
			
			
			
	    		* Containers Pods, Deployments and Services 
			
			
			
	    		* Kubernetes Architecture 
			
			
* Spring Boot with Kubernetes
	* Spring Boot and Kubernetes basics
		* Intro
		* Pros and Cons
		* Features
		* Spring MVC
		* Spring Boot demo
		* Lab Basic Spring App
		* Lab Docker and Kustomize
		* Lab Deploy app to Kubernetes (KIND, MiniKube, OpenShift CodeReady, GKE or EKS or ... etc.)  
	* Spring Boot and Kubernetes collaborating services 
		* Multiple services 
		* Front end and back end
		* Ingress rules and loadbalancers 
		* Spring Boot demo
		* Lab Basic Spring App
		* Lab Docker and Konfig
		* Lab Deploy app to Kubernetes (KIND, MiniKube, OpenShift CodeReady, etc.)  	
	* Spring Config 
		* Intro
	   	* Detail 
	   	* Detail
		* Config Maps
		* Mounting volumes
		* Spring Profiles
		* ... 
		* Using Spring config 
		* Using Spring config with Kubernetes config sets
		* Lab	
		* Lab	
		* Lab	
		* Lab	
	* Logging, DaemonSets, EFK 
		* Use Logging
		* Understanding Spring log support and sl4j & logback
		* Change log Level
		* Understanding Kubernetes Daemon sets redux
		* Setting up FluentD daemon sets
		* ElasticSearch and Kibana for log aggregation 
		* Lab setting up logging with Spring Boot and log4j
		* Lab viewing logs from Kubernetes 
		* Lab log aggregation with fluentd 
		* Using Kibana
	* Health checks and K8s probes
		* Intro
		* Spring Health checks
		* Health Details 
		* Custom health checks in Spring
		* Build Info
		* Kubernetes liveness probes 
		* Kubernetes ready probes
		* Lab setting up Spring Health Checks
		* Lab setting up a custom Spring Health Check
		* Lab setting up liveness and ready probes in Kubernetes 
	* Metrics and KPIs
		* Intro
		* Spring KPIs
		* Prometheus and Kubernetes 
		* Custom KPIs in Spring
		* Basics of Helm
		* Built-in KPIs
		* Lab setting up Spring KPIs
		* Lab setting up a metfics and custom metrics in Spring
		* Lab setting up Prometheus with helm in Kubernetes 
		* Lab setting up Prometheus annotations in Kubernetes
		* Lab exploring Prometheus 
		* Understanding Grafana 
		* Lab Setting up a grafana dashboard 
	* Istio and Service Mesh
		* Replacing Kubernetes Ingress rules with Istio 
		* ... Lot of stuff here
		* ... 
		* Lab 
	* Security
		* Intro
		* Lab Enable Security
	
* Advanced Kubernetes
    * Containers Pods, Deployments and Services 
    * Kubernetes Architecture 	

	
*** Optional 
	* Reactive	
	   * Detail  
	   * Lab
	   * Lab
	   * Lab 
	

# Future Stuff
* Node JS
* Quarkus
* Python
* Go


OpenShift 

Red Hat OpenShift on AWS


Spring Boot and OpenShift 
https://learn.openshift.com/middleware/courses/middleware-spring-boot/




https://aws.amazon.com/quickstart/architecture/openshift/

https://github.com/aws-quickstart/quickstart-redhat-openshift


Free OpenShift course

https://learn.openshift.com/

https://www.ibm.com/cloud/blog/deploying-helm-charts-on-openshift

https://blog.openshift.com/getting-started-helm-openshift/




OSE docs

https://docs.openshift.com/container-platform/4.2/service_mesh/service_mesh_arch/understanding-ossm.html


OSE mini container 


https://developers.redhat.com/products/codeready-containers/overview
