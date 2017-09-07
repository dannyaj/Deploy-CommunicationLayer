package MQ.CustomizeMQ.Producer.MQFactory;

import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;

public interface MQFactory {
    public MQProducer createProducer();
}
