package MQ.CustomizeMQ.Consumer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import MQ.RabbitMQ.Consumer.NonFeedbackConsumer;
import MsgHandler.MainService.MonitorService.MonitorService;
import MsgHandler.MsgHandler;

public class MonitorFactory implements MQFactory{

    @Override
    public LaunchableConsumer createConsumer(String[] args) {
        MsgHandler handler = new MonitorService();
        LaunchableConsumer consumer = new NonFeedbackConsumer(args, handler);
        return consumer;
    }
}
