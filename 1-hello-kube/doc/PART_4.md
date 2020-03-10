

## Ingress

TODO Explain what Ingress is and how it was added in Kubernetes 1.16.
Link to Ingress docs. Link to NGINX Ingress controller.

 Going to ...

#### Enable Minikube ingress  
```sh
$ minikube addons enable ingress
```

The above...

Next ...

#### You can see the nginx-ingress-controller is installed in the kube-system namespace
```sh

$ kubectl get pods -n kube-system
NAME                                        READY   STATUS    RESTARTS   AGE
...
etcd-minikube                               1/1     Running   1          4d22h
kube-apiserver-minikube                     1/1     Running   1          4d22h
...
nginx-ingress-controller-6fc5bcc8c9-88ghf   1/1     Running   0          89s
...

```
Note that ...

Now get the URL...

#### Use minikube service to show the URL

```sh  
$ minikube service hello-world --url

### Output
http://192.168.39.173:31192
```

The above shows ...

Next ...

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
This defines a ... which is ... so now you should see ...

Next ...

#### Use minikube service to show the URL
```sh  
$ kubectl apply -f hello-ingress.yaml

### Output
ingress.networking.k8s.io/hello-world-ingress created
```

The above ...

Since you don't have a local DNS server, you need to edit the ...


#### Add entry to /etc/host file  

```sh  
# echo "$(minikube ip)" hello-world.info >> /etc/hosts
```

The above ...

Next, you...

#### Show the new ingress entry  

```sh  

$ kubectl get ingress

### Output
NAME                  HOSTS              ADDRESS          PORTS     AGE
edge                  minikube.me        192.168.39.173   80, 443   4d23h
hello-world-ingress   hello-world.info   192.168.39.173   80        93s

```
The above ...

#### Show the contents of the /etc/host file
```sh
$ cat /etc/hosts
127.0.0.1	localhost
127.0.1.1	rick-linux
...
192.168.39.173	hello-world.info
```
See that the ...

#### Now ping the URL ...

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

#### Curl it  
```sh
$ curl hello-world.info
<html><body><H1>Hello World</H1></body></html>
```
TODO move ingress to another tutorail 
