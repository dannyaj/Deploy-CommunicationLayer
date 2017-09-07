package Runnable.Server.Monitor;

import Adapter.MongoDB.MongoDB;
import MQ.CustomizeMQ.Consumer.MQFactory;
import MQ.CustomizeMQ.Consumer.MonitorFactory;
import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import org.apache.log4j.Logger;
import Runnable.Runnable;

public class Monitor implements Runnable{

    private static Logger logger = Logger.getRootLogger();

    public void run(String[] args) {
        MongoDB.init(args);
        MQFactory factory = new MonitorFactory();
        LaunchableConsumer consumer = factory.createConsumer(args);
        consumer.launchConsumer();
    }
}
