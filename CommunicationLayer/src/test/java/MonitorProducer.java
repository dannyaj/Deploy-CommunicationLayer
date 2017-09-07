import MQ.CustomizeMQ.Producer.MQFactory.MonitorFactory;
import MQ.CustomizeMQ.Producer.MQFactory.MQFactory;
import MQ.CustomizeMQ.Producer.MQProducer.MQProducer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MonitorProducer {
    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        logger.setLevel(Level.DEBUG);
        String[] myargs = new String[10];
        myargs[0] = "-i";
        myargs[1] = "10.1.5.130";
        myargs[2] = "-r";
        myargs[3] = "iot.monitor.routing";
        myargs[4] = "-t";
        myargs[5] = "direct";
        myargs[6] = "-x";
        myargs[7] = "iot.monitor.exchange";
        myargs[8] = "-p";
        myargs[9] = "32607";

        for (String i : myargs)
            System.out.println(i);
        MQFactory factory = new MonitorFactory();
        MQProducer producer = factory.createProducer();
        producer.launchProducer(myargs);
    }
}
