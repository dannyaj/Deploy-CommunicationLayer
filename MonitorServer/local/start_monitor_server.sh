#!/bin/bash

java -jar MonitorServer.jar \
-i 10.1.5.184 \
-q iot.monitor.queue \
-r iot.monitor.routing \
-t direct \
-x iot.monitor.exchange \
-p 30500 \
-l debug \
-db_ip 10.1.5.184 \
-db_port 30490 \
-db_name iot
