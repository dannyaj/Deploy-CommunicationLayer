package MQ.RabbitMQ.Consumer;

import Tool.RabbitMQTool;
import com.rabbitmq.client.Channel;
import org.apache.commons.cli.ParseException;

public class RabbitMQConsumer {

    private Channel channel;
    private String queueName;

    public RabbitMQConsumer(String[] args) {

        // initial necessary variables
        ArgsParser parser = null;
        try {
            parser = new ArgsParser(args);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            System.exit(1);
        }

        String ip = parser.getIP();
        int port = parser.getPort();
        String user = parser.getUserName();
        String password = parser.getPassword();
        String queueName = parser.getQueueName();
        String exchangeName = parser.getExchange();
        String routingKey = parser.getRoutingKey();
        String type = parser.getExchangeType();
        // initial done

        // get connection channel
        Channel channel = RabbitMQTool.getRabbitMQChannel(ip, port, user, password);

        // declare channel, and then create queue if it doesn't exist
        channel = RabbitMQTool.declareRabbitMQChannel(channel, queueName, exchangeName, routingKey, type);

        this.channel = channel;
        this.queueName = queueName;

    }

    public String getQueueName() {
        return this.queueName;
    }

    public Channel getChannel() {
        return this.channel;
    }


}
