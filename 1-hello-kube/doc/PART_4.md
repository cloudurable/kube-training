

## Ingress

Ingress is an API object that manages external access and exposes HTTP and HTTPS routes from outside the cluster to services within the cluster. Traffic routing is controlled by rules defined on the Ingress resource.
It can provide load balancing, SSL termination and name-based virtual hosting.

You can see more about [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/) and [NGINX Ingress controller](https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/) clicking in the links.


 In this tutorial you will learn how to implement a Ingress Nginx on minikube

#### Start your Minikube cluster

Check if your minikube is running  
```sh
$ minikube status
```
##### Output
```sh
host: Running
kubelet: Running
apiserver: Running
kubeconfig: Running
```

If your minikube is running go to the **next step**.  

To start your Minikube cluster, run the command:

```sh
$ minikube start
```
##### Output
```sh
🎉  minikube 1.8.2 is available! Download it: https://github.com/kubernetes/minikube/releases/tag/v1.8.2
💡  To disable this notice, run: 'minikube config set WantUpdateNotification false'

🙄  minikube v1.7.3 on Linuxmint 18.3
✨  Using the kvm2 driver based on user configuration
👍  Kubernetes 1.17.3 is now available. If you would like to upgrade, specify: --kubernetes-version=1.17.3
⌛  Reconfiguring existing host ...
🔄  Starting existing kvm2 VM for "minikube" ...
🐳  Preparing Kubernetes v1.16.0 on Docker 19.03.6 ...
🚀  Launching Kubernetes ...
🌟  Enabling addons: default-storageclass, ingress, storage-provisioner
🏄  Done! kubectl is now configured to use "minikube"
```

Minikube is working.


#### Enable Minikube ingress addon

Run this command to enable Minikube ingress addon
```sh
$ minikube addons enable ingress
```
##### Output
```sh
🌟  The 'ingress' addon is enabled
```

#### You can see the nginx-ingress-controller is installed in the kube-system namespace
```sh
$ kubectl get pods -n kube-system
```
##### Output
```sh
NAME                                        READY   STATUS    RESTARTS   AGE
...
etcd-minikube                               1/1     Running   1          4d22h
kube-apiserver-minikube                     1/1     Running   1          4d22h
...
nginx-ingress-controller-6fc5bcc8c9-88ghf   1/1     Running   0          89s
...

```
Note that now you have a pod (**nginx-ingress**) running.


Now get the URL...

#### Use minikube service to show the URL

```sh  
$ minikube service hello-world --url

### Output
http://192.168.39.173:31192
```

The above shows ...

Next ...


#### Ingress resource

Now you need to create an Ingress resource. It sends traffic to your service.

Create a file hello-ingress.yaml from the following:
#### hello-ingress.yaml
```yaml
apiVersion: networking.k8s.io/v1beta1 # for versions before 1.14 use extensions/v1beta1
kind: Ingress
metadata:
  name: hello-world-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /$1
spec:
  rules:
  - host: hello-world.info
    http:
      paths:
      - path: /
        backend:
          serviceName: hello-world
          servicePort: 8080

```
This defines an Ingress resource sending the traffic on port 8080 to pod (hello-world.info).

You need to apply the resource created.

```sh  
$ kubectl apply -f hello-ingress.yaml
```
### Output
```sh
ingress.networking.k8s.io/hello-world-ingress created
```

Next, you need to verify if the new ingress entry was created.

#### Show the new ingress entry  

```sh  

$ kubectl get ingress

### Output
NAME                  HOSTS              ADDRESS          PORTS     AGE
edge                  minikube.me        192.168.39.173   80, 443   4d23h
hello-world-ingress   hello-world.info   192.168.39.173   80        93s

```
The above ...

Since you don't have a local DNS server, you need to edit the host file.

You can edit with your preffered text editor or type the following command:

#### Add entry to /etc/host file  

```sh  
# echo "$(minikube ip)" hello-world.info >> /etc/hosts
```

#### Show the contents of the /etc/host file
```sh
$ cat /etc/hosts
127.0.0.1	localhost
...
192.168.39.173	hello-world.info
```
See that the entry was created.

#### Now ping the URL

```sh
$ ping hello-world.info
PING hello-world.info (192.168.39.173) 56(84) bytes of data.
64 bytes from hello-world.info (192.168.39.173): icmp_seq=1 ttl=64 time=0.363 ms
64 bytes from hello-world.info (192.168.39.173): icmp_seq=2 ttl=64 time=0.381 ms
64 bytes from hello-world.info (192.168.39.173): icmp_seq=3 ttl=64 time=0.354 ms
64 bytes from hello-world.info (192.168.39.173): icmp_seq=4 ttl=64 time=0.223 ms
^C
--- hello-world.info ping statistics ---
4 packets transmitted, 4 received, 0% packet loss, time 3053ms
rtt min/avg/max/mdev = 0.223/0.330/0.381/0.063 ms

```

Great the pod is returning the ping.

To finalize test using the curl command.

#### Curl it  
```sh
$ curl hello-world.info
```
##### Output
```sh
<html><body><H1>Hello World</H1></body></html>
```
