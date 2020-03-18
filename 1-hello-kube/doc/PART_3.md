# Deploying Hello World Spring Boot example to Kubernetes

In this guide, you will deploy the Spring Boot hello-world application to Kubernetes.

If you are using Linux, use [this guide to set up minikube](https://github.com/cloudurable/kube-training/wiki/Set-up-on-Ubuntu-with-Docker-and-MiniKube-(Linux-Mint)), and if you are using [Mac use this guide to set up Minikube](http://cloudurable.com/blog/kubernetes_k8s_osx_setup_brew/index.html).

In this tutorial you will create Kubernetes manifest files with:

* a Deployment
* a Service using a NodePort
* an Ingress rule.

A **Deployment** is a Kubernetes object that maintains a set of identical pods, ensuring that they have the correct config and always in a runnable state, another words, it is not crashing or it is not dead or anything like that.  

A **Service** is an abstraction which defines a logical set of Pods and a policy by which to access them. The set of Pods targeted by a Service is usually determined by a selector.  

An **Ingress** rules exposes HTTP and HTTPS routes from outside the cluster to services within the cluster.

Before we create the manifest file, first let's start up minikube.  

Open a new terminal and type the following:
#### Start minikube
```sh
$ minikube start
```

The above will start minikube and then we can access our Kubernetes environment.


Next, you create a manifest file that contains a **service** and a **deployement** definitions.  

The service specification creates a new **service** object named “hello-world”, which targets TCP port 8080 on any Pod with the app=hello-world label.  
The service type is **NodePort** that exposes the service on each Node's IP at a static port. For some parts of your application (for example, frontends) you may want to expose a Service onto an external IP address, that’s outside of your cluster.You’ll be able to contact the NodePort Service, from outside the cluster, by requesting "NodeIP:NodePort".  

The deployment specification creates a single **pod** object named "hello-world", that uses our docker container previously created and uploaded to our docker hub "cloudurable/hello-kube:0.0.1".  
You will define the port that you will use "8080" and the commands that your pod will run "["java", "-jar", "/app.jar"]" when it is created.


#### hello-world.yaml
```yaml
apiVersion: v1
kind: Service
metadata:
  name: hello-world
spec:
  ports:
  - port: 8080
    name: hello-world
  selector:
    app: hello-world
  type: NodePort
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: hello-world
spec:
  selector:
    matchLabels:
      app: hello-world
  template:
    metadata:
      labels:
        app: hello-world
    spec:
      containers:
      - image: cloudurable/hello-kube:0.0.1
        name: hello-world
        ports:
        - containerPort: 8080
          name: hello-world
        command: ["java", "-jar", "/app.jar"]

```

Now you apply the manifest file.

#### Running manifest hello-world manifest file
```sh

$ kubectl apply -f  hello-first.yaml

### Output
service/hello-world created
deployment.apps/hello-world created

```

#### See that the hello-world is deployed
```sh
$ kubectl get pods

### Output
NAME                                 READY   STATUS    RESTARTS   AGE
...
hello-world-f4ffcdf47-kxz88          1/1     Running   0          42s
...
```

#### See that the hello-world service is deployed

```sh
$ kubectl get services

### Output
NAME                TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)                       AGE
...
hello-world         NodePort    10.107.55.167    <none>        8080/TCP                      52s
...
```
