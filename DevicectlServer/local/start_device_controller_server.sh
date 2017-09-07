#!/bin/bash

java -jar DeviceControllerServer.jar \
-i 10.1.5.184 \
-q iot.control.queue \
-r iot.control.routing \
-t direct \
-x iot.control.exchange \
-p 30500 \
-l debug
