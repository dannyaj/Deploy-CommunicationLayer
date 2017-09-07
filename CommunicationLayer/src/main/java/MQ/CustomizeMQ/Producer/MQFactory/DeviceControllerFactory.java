package MQ.CustomizeMQ.Producer.MQFactory;

import MQ.CustomizeMQ.Producer.MQProducer.DeviceController;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;

public class DeviceControllerFactory implements MQFactory {

    @Override
    public MQProducer createProducer() {
        return new DeviceController();
    }

}