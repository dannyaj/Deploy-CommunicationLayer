#!/bin/bash

java -jar MonitorApi.jar \
-i 10.1.5.184 \
-r iot.monitor.routing \
-t direct \
-x iot.monitor.exchange \
-p 30500 \
-l debug

