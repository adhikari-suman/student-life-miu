
# Docker setup for Lab

## 1. Setup ActiveMQ

```bash
docker run -d \
  --name activemq-container \
  --platform linux/amd64 \
  -e ACTIVEMQ_ADMIN_LOGIN=admin \
  -e ACTIVEMQ_ADMIN_PASSWORD=admin \
  -p 8161:8161 \
  -p 61616:61616 \
  -v ~/workspace/docker/activemq/config:/opt/activemq/conf \
  apache/activemq-classic:latest
```

## 2. Setup zookeeper

```bash
docker run -d \
  --name zookeeper-container \
  -e ZOOKEEPER_CLIENT_PORT=2181 \
  -p 2181:2181 \
  -v ~/workspace/docker/zookeeper/data:/var/lib/zookeeper/data \
  confluentinc/cp-zookeeper:latest
```

## 3. Setup Kafka

```bash
docker run -d \
  --name kafka-container \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_BROKER_ID=1 \
  -p 9092:9092 \
  -v ~/workspace/docker/kafka/data:/var/lib/kafka/data \
  --link zookeeper-container:zookeeper \
  wurstmeister/kafka:latest

```
