# kube-training
Kubernetes Training 


## Outlines 

* Core Concepts
	* uServices
		* Intro
			* **Definition**  
			A microservice is essentially an autonomous software component that is independently upgradeable and scalable.	
			* **Why Microservices?**  
			With microservices, your code is broken into independent services that run as separate processes. Output from one service is used as an input to another in an orchestration of independent, communicating services. Microservices is especially useful for businesses that do not have a pre-set idea of the array of devices its applications will support. By being device- and platform-agnostic, microservices enables businesses to develop applications that provide consistent user experiences across a range of platforms, spanning the web, mobile, IoT, wearables and fitness tracker environments.
			* **Scale and Distribution**  
			With uServices you can scale and distribute your application horizontally, only in the necessary services and not on your entire application, making it more intelligent and efficient in terms of performance and costs. Currently, cloud structures and uServices have Autoscaling functionality, which can increase the number of services when demand is high and the number of instances decreases when there is no demand, helping you in reducing costs.
				
	* Container Orchestrations with Kubernetes
		
	* Docker containers
		* **What is a container?**  
		A container is a standard unit of software that packages up code and all its dependencies so the application runs quickly and reliably from one computing environment to another.
		* **Why use Docker?**  
		Docker makes really easy to install and run new software without worrying about setup or dependencies.
		* **What is Docker?**  
		Docker is a platform or ecosystem around creating and running containers.
		* **Docker objects**  
		When you use Docker, you will create and will use some objects like as:
			* **Images**  
			A Docker container image is a lightweight, standalone, executable package of software that includes everything needed to run an application: code, runtime, system tools, system libraries and settings.
			An image is a read-only template with instructions for creating a Docker *container*. An image could be based on another image, with additional customization. You might create your own image or you can choose those created by others and published a registry.
			* **Containers**  
			Container is a runnable instance of an image. A container is defined by its imge as well as any configuration options you provide to it when you create or start it. When container is removed, any changes to its state thare are not sotred in persistent storage disappear.
			* **Services**  
			A service allows you to define the desired state, such as the number of replicas of the service that must be available at any given time. By default, the service is load-balanced across all worker nodes.
		* **Container orchestration**  
		Conteiner orchestration is all about managing the lifecycles of containers, especially in large, dynamic environments. DevOps teams use container orchestration to control and automate many tasks, included:
			* Provisioning and deployment of containers;
			* Redundancy and availability of containers;
			* Slaing up or removing containers to spread application load evenly across host infrastructure;
			* Movement of containers from one host to another if there is a shortage of resources in a host, or if a host dies;
			* Allocation of resources between containers;
			* External exposure of services running in a container with the outside world;
			* Load balancing of service discovery between containers;
			* Health monitoring of containers and hosts;
			* Configuration of an application in relation to the containers running it.  
		An exemple of container orchestrator is **Kubernetes** or **Docker Swarm**.
			
	* **Kubernetes**
		* **What is?**  
		Originally developed by Google, Kubernetes has established itself as the *de facto* standard for container orchestration. It continues to gain popularity with DevOps pratictoners because it allows them to deliver a self-service Platform-as-a-Service (PaaS) that creates a layer abstraction for development teams and Kubernetes is also extremely portable. You can run Kubernetes projects on Amazon Web Services (AWS), Microsoft Azure (AKS), the Google Cloud Plataform (GCP), Red Hat OpenShift, or in on-premise installations. You can move workloads without having to redesign your applications or completely rethink your infrastructure.
		* **Architecture:**  
		The main architecture components of Kubernetes include:
			* **Cluster**  
			A cluster is a set of nodes with at least one master node and several work nodes that can be virtual or physical machines.
			* **Kubernetes Master**  
			The master manages the scheduling and deployment of application instances across nodes, and the full set of services the master node runs is known as *the control plane*. The master communicates with nodes through the Kubernets API server. The scheduler assigns nodes to pods (one or more containers) depending on the resource and policy constraints you have defined.
			* **Kubelet**  
			Is the agent that runs in each kubernetes node. It is responsible for managing the state of the node: starting, stopping, and maintaining application containers based on instructions from the control plane. The kubelet receives all of its information from the Kubernets API server.
			* **Pods**  
			The basic sheduling unit, which consists of one or more containers guaranteed to be colocated on the host machine and able to share resources. You describe the desired state of the containers in a pod through a YAML or JSON object called a PodSpec. These objects are passed to the kubelet through the API server.
			* **Deployments, replicas, and ReplicaSets**  
			A deployment is a YAML object that defines the pods and the number of container instances, called replicas, for each pod. You define the number of replicas you want to have running in the cluster via ReplicaSet, which is part of the deployment object.
		
		
		* **Containers Pods, Deployments and Services** 
			
			
			
	    		
			
			
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
