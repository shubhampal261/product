#!/bin/sh

echo "I'm in docker image"

cd $HOME

java -agentlib:jdwp=transport=dt_socket,address=8091,server=y,suspend=n -jar ./product-1.0.0-SNAPSHOT.jar

echo "Product Service module successfully deployed!!"