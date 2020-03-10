# Deploying Hello World Spring Boot example to Kubernetes

In this guide, you will deploy the Spring Boot hello-world application to Kubernetes.

If you are using Linux, use [this guide to set up minikube](https://github.com/cloudurable/kube-training/wiki/Set-up-on-Ubuntu-with-Docker-and-MiniKube-(Linux-Mint)), and if you are using [Mac use this guide to set up Minikube](http://cloudurable.com/blog/kubernetes_k8s_osx_setup_brew/index.html).

In this tutorial you will create Kubernetes manifest files with:

* a Deployment
* a Service using a NodePort
* an Ingress rule.

A Deployment is....
A Service is ....
An Ingress rules does ...

Before we create the manifest file, first let's start up minikube.  (Minikube status)

#### Start minikube
```sh
$ minikube start
```

The above will start minikube and then we can access our Kubernetes environment.


Next, you create a manifest file that ...  TODO


#### hello-first.yaml
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
  strategy:
    type: Recreate
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

Now you apply the manifest file. (TODO please rename to hello-first.yaml to hello-world.yaml).

#### Running manifest hello-first manifest file
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
