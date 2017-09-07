package Runnable;


import ExtendThirdParty.ExtendedGnuParser;
import org.apache.commons.cli.*;
import org.apache.log4j.Level;

public class ArgsParser {

    private CommandLine cmd;
    private Options options;

    public ArgsParser(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("l", "level", true, "Logger Level");

        CommandLineParser parser = new ExtendedGnuParser(true);
        cmd = parser.parse(options, args);

    }

    public Level getLevel() {
        if (!cmd.hasOption("l") || !cmd.hasOption("level"))
            return Level.INFO;

        String level = cmd.getOptionValue("l");
        System.out.println(level);
        if (level.equals("info"))
            return Level.INFO;
        if (level.equals("debug"))
            return Level.DEBUG;
        if (level.equals("warn"))
            return Level.WARN;
        if (level.equals("error"))
            return Level.ERROR;
        if (level.equals("fatal"))
            return Level.FATAL;

        return Level.INFO;

    }
}