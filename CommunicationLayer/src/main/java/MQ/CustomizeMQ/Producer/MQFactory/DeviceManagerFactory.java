package MQ.CustomizeMQ.Producer.MQFactory;

import MQ.CustomizeMQ.Producer.MQProducer.DeviceManager;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;

public class DeviceManagerFactory implements MQFactory {

    @Override
    public MQProducer createProducer() {
        return new DeviceManager();
    }
}
