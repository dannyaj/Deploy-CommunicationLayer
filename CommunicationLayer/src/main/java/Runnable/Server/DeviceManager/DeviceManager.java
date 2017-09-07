package Runnable.Server.DeviceManager;

import Adapter.MongoDB.MongoDB;
import MQ.CustomizeMQ.Consumer.DeviceManagerFactory;
import MQ.CustomizeMQ.Consumer.MQFactory;
import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import org.apache.log4j.Logger;
import Runnable.Runnable;

public class DeviceManager implements Runnable{

    private static Logger logger = Logger.getRootLogger();

    public void run(String[] args) {
        MongoDB.init(args);
        MQFactory factory = new DeviceManagerFactory();
        LaunchableConsumer consumer = factory.createConsumer(args);
        consumer.launchConsumer();
    }

}
