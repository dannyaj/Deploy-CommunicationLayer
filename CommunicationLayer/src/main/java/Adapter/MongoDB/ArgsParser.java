package Adapter.MongoDB;

import ExtendThirdParty.ExtendedGnuParser;
import org.apache.commons.cli.*;

class ArgsParser {

    CommandLine cmd;

    public ArgsParser(String[] args) {
        Options options = new Options();
        options.addOption("db_ip", true, "Mongo DB IP");
        options.addOption("db_port", true, "Mongo DB port");
        options.addOption("db_name", true, "Mongo DB Name");

        CommandLineParser parser = new ExtendedGnuParser(true);
        try {
            this.cmd = parser.parse(options, args);
            this.validate(options);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private boolean validate(Options options) {
        if (!cmd.hasOption("db_ip") || !cmd.hasOption("db_name")) {
            HelpFormatter hf = new HelpFormatter();
            hf.setWidth(110);
            hf.printHelp("testApp", options, true);
            System.out.println("failed");
            System.exit(-1);
        }
        return true;
    }

    public String getIP() { return cmd.getOptionValue("db_ip"); }

    public int getPort() {
        if (cmd.hasOption("db_port"))
            return Integer.parseInt(cmd.getOptionValue("db_port"));
        return 27017;
    }

    public String getDB() { return cmd.getOptionValue("db_name"); }

}
