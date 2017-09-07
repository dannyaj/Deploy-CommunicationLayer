package Runnable.Edge.Monitor;

import MQ.CustomizeMQ.Producer.MQFactory.MQFactory;
import MQ.CustomizeMQ.Producer.MQFactory.MonitorFactory;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;
import Runnable.Runnable;
import org.apache.log4j.Logger;

public class Monitor implements Runnable {

    private static Logger logger = Logger.getRootLogger();

    public void run (String[] args) {
        MQFactory factory = new MonitorFactory();
        MQProducer producer = factory.createProducer();
        producer.launchProducer(args);
    }
}
