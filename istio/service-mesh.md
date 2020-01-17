# Istio Service Mesh

---
# Istio Service Mesh
## What is Service Mesh?

---

# What is Service Mesh?
* Network services for **microservices**
* Policy-based, enforces behaviors
* Manages topology, changing conditions: load, configuration, resources
* Spans clusters/clouds (Mesos clusters, VMs, Cloud, K8s, Consul)
* Provides discovery, load balancing, failure recovery, and observability
* Supports A/B testing, canary releases, rate limiting, access control, 0 trust networks

---
# What is Service Mesh?

* Addressable infrastructure layer
* Developer-driven, services-first network
* Takes network concerns out of service / application code (e.g., resiliency, circuit breakers, etc.)
* Declaratively define network behavior by policy: node identity, routing, balancing, and traffic flow
* Language and framework agnostic support for observability and tracing
* ~= Cloud Native Software defined network

---
# Istio Service Mesh
## Network Services

---

# Istio Service Mesh  
## Network Services

* Traffic Management
* Observability
* Policy Enforcement
* Service Identity & Security

___

## Service Mesh - Network Services
# Traffic Management
* Control traffic flow
  * REST/RPC calls between services
  * Level 7 and Level 4
* Reliable & Robust
  * Load balancers
  * Health-checks
  * Circuit breakers

___

## Service Mesh - Network Services
# Observability
* Understanding topology of service dependencies
* Visualize traffic flow between services
* Tracing
* Log aggregation
* KPIs/Metrics

___

## Service Mesh - Network Services
# Policy Enforcement

* mTLS and Zero trust networking
* Control interaction between services
* Enforce access policies
* Ensure resources fairly distributed
* Keeps policy concerns out of application code
* Services have verifiable identity
* Rate limiting based on identity of service traffic (trustability can vary)

____
TODO look at section in Istio book value of Service Mesh
___

# Istio Service Mesh
## Architecture

---
# Service Mesh - Architecture
* Management Plane
* Control Plane
* Data Plane
* Ingress Gateway
* Egress Gateway

___

## Service Mesh - Architecture
# Management Plane
* Governance - Multi-cluster and multi-mesh
* Integration with existing clouds and environments  
* Federation
* Intelligent services

___

## Service Mesh - Architecture
# Control Plane
* Policy, config, routes, rules and platform integration
* Configs Set of Side car service proxies (per pod)
* Does not intercept or route any network traffic
* Config and config propagation

___

## Service Mesh - Architecture
# Data Plane
* Uses configured policies, routes, rules and platform integration
* Intercepts and routes network traffic
* Encryption (TLS), Authentication, and Authorization
* Health checks, routing, load balancing, and observability
* Service Discovery

____

## Service Mesh - Architecture
* Service meshes consist of service proxies (data plane), which are configured by the control plane
* Traffic is intercepted using iptables rules per pod
* Service Mesh: Combination of policies managed by control plane plus data plane that implements policy behavior plus service deployments
* Istio turns disparate microservices into an integrated service mesh
  * by systemically injecting service proxy that controls all network paths

____

## Service Mesh versus Client Libs
* a
* b
* c

___

## Why service meshes are being adopted
* a
* b
* c


___

## Service Mesh Capabilities
* a
* b
* c

___


## Service Mesh Landscape
* a
* b
* c

___


## Service Mesh Ecosystem
* API gateways
* L4 to L7
* East west vs. North South
* HAProxy, Traefik, NGINX, Envoy, Ambassador, GKE, EKS, AKS,

____


## Service Mesh Landscape
* a
* b
* c

____


## Service Mesh - Layer 5
* a
* b
* c

____


## mTLS explained
* mTLS
____


## TLS explained
* TLS headers
* SNI
___

## IPTables
* ...
* ...
* ...

___

## Origins of Istio
* a
* b
* c

____


## Istio Architecture
* a
* b
* c
____


## Service Mesh - Observability
* a
* b
* c

____

## Installing Istio
* a
* b
* c

____


## Service Proxy
* a
* b
* c

____


## Envoy  
* gRPC
* HTTP 2
* REST to gRPC

____


## Sidecar Proxy  
* Injection
* Manual Injection
* Ad Hoc

____


## Security and Identity   
* a
* b
* c

____

## SPIFFE

* Istio implements the Secure Production Identity Framework for Everyone (SPIFFE) specification
* Spec wrt issuing identities
* Istio creates X.509 certificate
* Istio uses certificate’s subject alternative name (SAN)
* SAN is a URI for the service
* Uses pod service account name
* URI: spiffe://$ClusterName/ns/$Namespace/sa/$ServiceAccountName

____

## Istio Config
* All
* Connection models
* JWT support



____

## Istio RBSC
* Config
* A
* B


____

## Pilot
* Config
* A
* B

____

## Pilot Mesh Config
* Config
* A
* B

____

## Pilot Networking Config  
* Config
* A
* B
____

## Pilot Service Discovery
* Config
* A
* B

____

## Traffic Management   
* Config
* A
* B

____

## Traffic Management Config  
* ServiceEntry
* DestinationRule
* VirtualService
* Gateway

____

## Telemetry    
* Config
* A
* B

____

## Deployments    
* Green / Blue
* Canary
* Advanced Canary

____

## Resiliency    
* Client Side Load Balancing  
* Circuit breaking
* Auto Retry
* Request timeouts
* Injecting faults to test resiliency

____

## Ingress and Egress    
* A
* B
* C

____

## Mixers    
* Policies
* Attributes
* Adapters
* Config


____

# Telemetry
* Adapters
* Metrics
* Logs
* Visualization

____

# Trouble shooting
* A
* B
* C

____


# Multi-clusters  
* Single Mesh
* Mesh Federation


____


# Multi-clusters
* Flat networking not needed since Istio 1.1
* EDS (Pilot API that mirrors Envoy)
    * Local only config
* TLS SNI routing
    * inter-cluster connectivity
* Split Horizon     



____


# Istio Multi-clusters
* Istio determines locality based on names for routing
* Uses Kube labels and annotations for cluster awareness
* Supports geo locality, cluster locality for LB
* Proxy assigns services cluster labels
* Use GitOps to sync names and config for multiple control planes


____


# Use Cases Multi cluster
* HA
* Cross-provider
* Deployment strategies (A/B, Canary, Blue/Green)
* Migration
