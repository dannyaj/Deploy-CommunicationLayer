package MQ.RabbitMQ.Producer;

import ExtendThirdParty.ExtendedGnuParser;
import com.rabbitmq.client.AMQP;
import org.apache.commons.cli.*;

public class ArgsParser {

    private CommandLine cmd;
    private Options option;

    public ArgsParser(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("i", "ip", true, "RabbitMQ Server's IP");
        options.addOption("p", "port", true, "RabbitMQ Server's Port(Option)");
        options.addOption("x", "exchange", true, "Exchange Name");
        options.addOption("r", "routing", true, "Routing Key");

        CommandLineParser parser = new ExtendedGnuParser(true);
        cmd = parser.parse(options, args);
        this.validate(options);
    }

    private boolean validate(Options options) {
        if (!cmd.hasOption("i") || !cmd.hasOption("ip")
                || !cmd.hasOption("x") || !cmd.hasOption("exchange")
                || !cmd.hasOption("r") || !cmd.hasOption("routing") ) {

            HelpFormatter hf = new HelpFormatter();
            hf.setWidth(110);
            hf.printHelp("testApp", options, true);
            System.out.println("failed");
            System.exit(-1);
        }
        return true;
    }

    public String getIP() {
        return cmd.getOptionValue("i");
    }

    public Integer getPort() {
        if (!cmd.hasOption("p") || !cmd.hasOption("port"))
            return AMQP.PROTOCOL.PORT;
        return Integer.parseInt(cmd.getOptionValue("p"));
    }

    public String getExchange() { return cmd.getOptionValue("x"); }

    public String getRoutingKey(){
        return cmd.getOptionValue("r");
    }

    public String getUserName() { return ""; }

    public String getPassword() { return ""; }
}