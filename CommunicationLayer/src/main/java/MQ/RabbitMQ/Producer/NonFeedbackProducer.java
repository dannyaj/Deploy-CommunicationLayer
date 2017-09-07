package MQ.RabbitMQ.Producer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableProducer;

import com.rabbitmq.client.Channel;
import org.apache.log4j.Logger;

import java.io.IOException;

public class NonFeedbackProducer extends RabbitMQProducer implements LaunchableProducer {

    private static Logger logger = Logger.getRootLogger();

    public NonFeedbackProducer(String[] args) {
        super(args);
    }

    public String sendMessage(String msg) {

        String routingKey = super.getRoutingKey();
        String exchange = super.getExchange();
        Channel channel = super.getChannel();
        try {
            channel.basicPublish(exchange, routingKey, null, msg.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        return "";
    }
}
