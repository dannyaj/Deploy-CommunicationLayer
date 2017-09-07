package MQ.RabbitMQ.Consumer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;
import MsgHandler.MsgHandler;

import com.rabbitmq.client.*;
import org.apache.log4j.Logger;
import java.io.IOException;

public class NonFeedbackConsumer extends RabbitMQConsumer implements LaunchableConsumer {

    private static Logger logger = Logger.getRootLogger();
    private MsgHandler msgHandler;

    public NonFeedbackConsumer(String[] args, MsgHandler msgHandler) {
        super(args);
        this.msgHandler = msgHandler;
    }

    @Override
    public void launchConsumer() {

        Channel channel = super.getChannel();
        String queueName = super.getQueueName();

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                try {
                    String message = new String(body,"UTF-8");
                    logger.debug("Receive: "+message);
                    msgHandler.handleMsg(message);
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
                catch (RuntimeException e){
                    logger.fatal(e.toString());
                    System.exit(1);
                }
            }
        };

        try {
            logger.debug("Non-Feedback Consumer start with queue name \"" + queueName + "\"");
            channel.basicConsume(queueName, false, consumer);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
