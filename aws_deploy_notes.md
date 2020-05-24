# Setting up AWS Kube Cluster

[Getting started with Amazon EKS](https://docs.aws.amazon.com/eks/latest/userguide/getting-started.html
)
[Getting started with eksctl](https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html)

Cluster with Linux only workers:
```
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