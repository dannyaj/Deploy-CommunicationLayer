package Runnable.Server.DeviceController;

import MQ.CustomizeMQ.Consumer.DeviceControllerFactory;
import MQ.CustomizeMQ.Consumer.MQFactory;
import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import org.apache.log4j.Logger;
import Runnable.Runnable;

public class DeviceController implements Runnable {

    private static Logger logger = Logger.getRootLogger();

    public void run(String[] args) {
        MQFactory factory = new DeviceControllerFactory();
        LaunchableConsumer consumer = factory.createConsumer(args);
        consumer.launchConsumer();
    }
}
