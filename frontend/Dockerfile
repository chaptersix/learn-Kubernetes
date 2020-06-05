# stage1 as builder
FROM node:10-alpine as builder

WORKDIR /app
# copy the package.json to install dependencies
COPY package.json package-lock.json /app/

# Install the dependencies and make the folder
RUN npm install

COPY . /app


# Build the project and copy the files
RUN npm run ng build -- --configuration="production"


FROM nginx:alpine

#!/bin/sh

COPY ./.nginx/nginx.conf /etc/nginx/nginx.conf

## Remove default nginx index page
RUN rm -rf /usr/share/nginx/html/*

# Copy from the stahg 1
COPY --from=builder /app/dist/frontend /usr/share/nginx/html

EXPOSE 4200 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]