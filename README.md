the start of this project is based off the following articale: https://www.freecodecamp.org/news/learn-kubernetes-in-under-3-hours-a-detailed-guide-to-orchestrating-containers-114ff420e882/


- I will then modify the app to do sentament analysis on articales, swap out java spring for golang, and switch internal communications to grpc, ci/cd on aws, builds are still relying on dev machine 

the readme will also improve :)



copied sa-frontend folder from  articale github repo. 
ran npm install -> npm audit fix -> yarn -> yarn build -> docker build .


copied sa-logic from github repo
docker build . -> there were gcc issues with the python doc image -> changed base image to python:3.7.7-slim-buster and updated the requirements.txt  to Werkzeug==1.0.1 Flask==1.1.2 textblob==0.15.3


copied sa-webapp from github repo
mvn install -> docker build .

install kubectl sudo snap install kubectl
sudo apt install qemu-kvm
install minikube - single node kub cluster in virutal machine on your computer
    curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 \
  && chmod +x minikube
  sudo install minikube /usr/local/bin/
  minikube start