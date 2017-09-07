package Runnable.Edge.DeviceController;

import MQ.CustomizeMQ.Producer.MQFactory.DeviceControllerFactory;
import MQ.CustomizeMQ.Producer.MQFactory.MQFactory;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;
import Runnable.Runnable;
import org.apache.log4j.Logger;

public class DeviceController implements Runnable {

    private static Logger logger = Logger.getRootLogger();

    public void run (String[] args) {
        MQFactory factory = new DeviceControllerFactory();
        MQProducer producer = factory.createProducer();
        producer.launchProducer(args);
    }
}
