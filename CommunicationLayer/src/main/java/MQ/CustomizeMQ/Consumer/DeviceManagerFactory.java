package MQ.CustomizeMQ.Consumer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import MQ.RabbitMQ.Consumer.FeedbackConsumer;
import MsgHandler.MainService.DeviceManagerService.DeviceManagerService;
import MsgHandler.MsgHandler;

public class DeviceManagerFactory implements MQFactory{

    @Override
    public LaunchableConsumer createConsumer(String[] args) {
        MsgHandler handler = new DeviceManagerService();
        LaunchableConsumer consumer = new FeedbackConsumer(args, handler);
        return consumer;
    }
}
