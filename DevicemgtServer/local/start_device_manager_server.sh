#!/bin/bash

java -jar ServerSide/DeviceManagerServer.jar \
-i 10.1.5.184 \
-q iot.devicemgt.queue \
-r iot.devicemgt.routing \
-t direct \
-x iot.devicemgt.exchange \
-p 30500 \
-l debug \
-db_ip 10.1.5.184 \
-db_port 30490 \
-db_name iot
