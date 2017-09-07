package MQ.CustomizeMQ.Consumer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import MQ.RabbitMQ.Consumer.NonFeedbackConsumer;
import MsgHandler.MainService.DeviceControllerService.DeviceControllerService;
import MsgHandler.MsgHandler;

public class DeviceControllerFactory implements MQFactory{

    @Override
    public LaunchableConsumer createConsumer(String[] args) {
        MsgHandler handler = new DeviceControllerService();
        LaunchableConsumer consumer = new NonFeedbackConsumer(args, handler);
        return consumer;
    }
}