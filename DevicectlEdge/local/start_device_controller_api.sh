#!/bin/bash

java -jar ControllerApi.jar \
-i 10.1.5.184 \
-r iot.control.routing \
-t direct \
-x iot.control.exchange \
-p 30500 \
-l debug
