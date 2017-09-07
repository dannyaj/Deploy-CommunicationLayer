package MQ.RabbitMQ.Producer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableProducer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FeedbackProducer extends RabbitMQProducer implements LaunchableProducer {

    private static Logger logger = Logger.getRootLogger();

    public FeedbackProducer(String[] args) {
        super(args);
    }

    public String sendMessage(String msg) throws IOException, InterruptedException {

        String routingKey = super.getRoutingKey();
        String exchange = super.getExchange();
        Channel channel = super.getChannel();
        String corrId = UUID.randomUUID().toString();
        String replyQueueName = channel.queueDeclare().getQueue();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish(exchange, routingKey, props, msg.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                response.offer(new String(body, "UTF-8"));
                channel.basicCancel(consumerTag);
            }
        });
        return response.take();
    }
}

