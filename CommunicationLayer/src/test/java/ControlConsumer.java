import MQ.CustomizeMQ.Consumer.DeviceControllerFactory;
import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import MQ.CustomizeMQ.Consumer.MQFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ControlConsumer {

    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        logger.setLevel(Level.DEBUG);
        String[] myargs = new String[12];
        myargs[0] = "-i";
        myargs[1] = "10.1.5.130";
        myargs[2] = "-q";
        myargs[3] = "control.queue";
        myargs[4] = "-r";
        myargs[5] = "control.routing";
        myargs[6] = "-t";
        myargs[7] = "direct";
        myargs[8] = "-x";
        myargs[9] = "control.exchange";
        myargs[10] = "-p";
        myargs[11] = "32607";

        for (String i : myargs)
            System.out.println(i);
        MQFactory factory = new DeviceControllerFactory();
        LaunchableConsumer consumer = factory.createConsumer(myargs);
        consumer.launchConsumer();
    }
}
