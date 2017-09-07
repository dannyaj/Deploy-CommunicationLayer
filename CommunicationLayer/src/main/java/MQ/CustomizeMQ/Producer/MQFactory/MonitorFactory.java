package MQ.CustomizeMQ.Producer.MQFactory;

import MQ.CustomizeMQ.Producer.MQProducer.Monitor;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;

public class MonitorFactory implements MQFactory {

    @Override
    public MQProducer createProducer() {
        return new Monitor();
    }
}