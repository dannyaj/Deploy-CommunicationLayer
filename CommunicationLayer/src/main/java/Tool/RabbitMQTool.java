package Tool;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMQTool {

    public static Channel getRabbitMQChannel(String ip, int port, String user, String password) {
        /*
            Create a RabbitMQ Channel
            Example
                ip: "10.10.1.158"
                port: 100
                user: "guest"
                password: "guest"
                return a RabbitMQ channel
         */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ip);
        factory.setPort(port);
//        factory.setUsername(user);
//        factory.setPassword(password);

        try {
            Connection connection = factory.newConnection();
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            return channel;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(1);
        return null;

    }

    public static Channel declareRabbitMQChannel(Channel channel, String queueName, String exchangeName, String routingKey, String type) {

        /*
            declare a RabbitMQ channel
            this function will use a channel to create a queue
            Example
                channel: a Channel object
                queueName: "iot-queue"
                routingKey: "iot-routing-key"
                type: "direct" or "topic"
                return: a Channel object
         */

        try {
            channel.queueDeclare(queueName, false, false, true, null);
            channel.exchangeDeclare(exchangeName, type);
            channel.basicQos(1);
            channel.queueBind(queueName, exchangeName, routingKey);
            return channel;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(1);
        return null;

    }
}
