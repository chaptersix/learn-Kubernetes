# Setting up AWS Kube Cluster

## Setup awscli on WSL

[Follow this tutorial](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux.html)

## Setup eksctl

[Getting started with eksctl](https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html)


[Getting started with Amazon EKS](https://docs.aws.amazon.com/eks/latest/userguide/getting-started.html)

## Setup eks service with eksctl
Cluster with Linux only workers:

``` bash
eksctl create cluster \
--name prod \
--version 1.16 \
--region us-west-2 \
--nodegroup-name standard-workers \
--node-type t3.medium \
--nodes 3 \
--nodes-min 1 \
--nodes-max 4 \
--ssh-access \
--ssh-public-key my-public-key.pub \
--managed
```
## Setup kubectl

Execute the following to setup kubectl:

``` bash
aws eks --region us-east-2 update-kubeconfig --name prod
```

to test:
``` bash
kubectl get svc
```

Add kubernetes dashboard:
``` bash
https://docs.aws.amazon.com/eks/latest/userguide/dashboard-tutorial.html
```


Setup s3 bucket for kops config
```
aws s3api create-bucket --bucket stanfield-kubernetes-aws-io --region us-east-2 --create-bucket-configuration LocationConstraint=us-east-2

{
    "Location": "http://stanfield-kubernetes-aws-io.s3.amazonaws.com/"
}

```

Enable versioning
```
aws s3api put-bucket-versioning --bucket kubernetes-aws-io --versioning-configuration Status=Enabled
```

```
export KOPS_STATE_STORE=s3://stanfield-kubernetes-aws-io
export CLUSTER_NAME=stanfieldcluster.k8s.local
export NODE_SIZE=a1.large
export MASTER_SIZE=a1.large
export ZONES=us-east-2a
```

[Followed the first to setup Gossip based cluster](https://rancher.com/blog/2020/three-way-to-run-aws)

## AWS is cost prohibative at the momemnt