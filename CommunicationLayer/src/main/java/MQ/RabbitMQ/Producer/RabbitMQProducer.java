package MQ.RabbitMQ.Producer;

import Tool.RabbitMQTool;
import com.rabbitmq.client.Channel;
import org.apache.commons.cli.ParseException;

public class RabbitMQProducer {

    private Channel channel;
    private String exchange;
    private String routingKey;

    public RabbitMQProducer(String[] args) {

        // parse and initial necessary variables
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
        this.exchange = parser.getExchange();
        this.routingKey = parser.getRoutingKey();

        // get connection channel
        Channel channel = RabbitMQTool.getRabbitMQChannel(ip, port, user, password);

        this.channel = channel;
    }

    public Channel getChannel() { return this.channel; }

    public String getExchange() { return this.exchange; }

    public String getRoutingKey() { return this.routingKey; }
}
