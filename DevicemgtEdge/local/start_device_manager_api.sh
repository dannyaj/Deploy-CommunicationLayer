#!/bin/bash

java -jar APIServer/DeviceManagerApi.jar \
-i 10.1.5.184 \
-r iot.devicemgt.routing \
-t direct \
-x iot.devicemgt.exchange \
-p 30500 \
-l debug
