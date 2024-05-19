#!/bin/sh
kafka-topics --bootstrap-server localhost:9092 \
  --create \
  --topic mytopic \
  --partitions 10 \
  --if-not-exists