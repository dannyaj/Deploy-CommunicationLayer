package Runnable.Edge.DeviceManager;

import Adapter.MongoDB.MongoDB;
import MQ.CustomizeMQ.Producer.MQFactory.DeviceManagerFactory;
import MQ.CustomizeMQ.Producer.MQFactory.MQFactory;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;
import org.apache.log4j.Logger;
import Runnable.Runnable;

public class DeviceManager implements Runnable{

    private static Logger logger = Logger.getRootLogger();

    public void run (String[] args) {
        MQFactory factory = new DeviceManagerFactory();
        MQProducer producer = factory.createProducer();
        producer.launchProducer(args);
    }
}
