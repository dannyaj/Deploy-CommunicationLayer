package Runnable.Edge.DeviceManager;

import Runnable.Runnable;
import Runnable.ArgsParser;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

public class Run {

    private static Logger logger = Logger.getRootLogger();

    static public void main(String[] args) throws ParseException {

        ArgsParser parser = new ArgsParser(args);
        logger.setLevel(parser.getLevel());

        Runnable task = new DeviceManager();
        task.run(args);
    }
}
