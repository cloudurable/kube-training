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

Open a new terminal and go to your project folder:
```sh
$ cd firstproject/HelloWorld/
```
##### Output
```sh
<youruser@yourpcname>:~/firstproject/HelloWorld$
```

#### Start minikube
Type the following:
```sh
$ minikube start
```
##### Output  
```sh
😄  minikube v1.8.2 on Ubuntu 18.04
✨  Automatically selected the kvm2 driver. Other choices: docker, none
💾  Downloading driver docker-machine-driver-kvm2:
    > docker-machine-driver-kvm2.sha256: 65 B / 65 B [-------] 100.00% ? p/s 0s
    > docker-machine-driver-kvm2: 13.88 MiB / 13.88 MiB  100.00% 5.00 MiB p/s 3
💿  Downloading VM boot image ...
    > minikube-v1.8.0.iso.sha256: 65 B / 65 B [--------------] 100.00% ? p/s 0s
    > minikube-v1.8.0.iso: 173.56 MiB / 173.56 MiB [-] 100.00% 19.24 MiB p/s 9s
💾  Downloading preloaded images tarball for k8s v1.17.3 ...
    > preloaded-images-k8s-v1-v1.17.3-docker-overlay2.tar.lz4: 499.26 MiB / 499
🔥  Creating kvm2 VM (CPUs=2, Memory=2200MB, Disk=20000MB) ...
🐳  Preparing Kubernetes v1.17.3 on Docker 19.03.6 ...
🚀  Launching Kubernetes ...
🌟  Enabling addons: default-storageclass, storage-provisioner
⌛  Waiting for cluster to come online ...
🏄  Done! kubectl is now configured to use "minikube"
```

The above will start **minikube** and then we can access our Kubernetes environment.

Next, you need to create a manifest file that contains a **service** and a **deployement** definitions.  

The service specification creates a new **service** object named “hello-world”, which targets TCP port 8080 on any Pod with the app=hello-world label.  
The service type is **NodePort** that exposes the service on each Node's IP at a static port. For some parts of your application (for example, frontends) you may want to expose a Service onto an external IP address, that’s outside of your cluster.You’ll be able to contact the NodePort Service, from outside the cluster, by requesting "NodeIP:NodePort".  

The deployment specification creates a single **pod** object named "hello-world", that uses our docker container previously created and uploaded to our docker hub "cloudurable/hello-kube:0.0.1".  
You will define the port that you will use "8080" and the commands that your pod will run "["java", "-jar", "/app.jar"]" when it is created.

Let's do it:
```sh
$ nano hello-world.yaml
```

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
$ kubectl apply -f  hello-world.yaml
```

### Output
```sh
service/hello-world created
deployment.apps/hello-world created

```

#### See that the hello-world is deployed
```sh
$ kubectl get pods
```

### Output
```sh
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

#### Testing the app

You need to **enter** inside the running pod. For this type the following command:
```sh
$ kubectl exec -it <pod-name> -- /bin/bash
```
##### Output
```sh
bash-4.2#
```
<The **it** parameter is used to interact with the pod. In our case we will interact using **shell (/bin/bash)**.>


Testing the app:
```sh
# curl localhost:8080
```
##### Output
```sh
<html><body><H1>Hello World</H1></body></html>
```
Good job, pod and app working fine!!!  

Now let's go to the part-4 for publish and access our app
