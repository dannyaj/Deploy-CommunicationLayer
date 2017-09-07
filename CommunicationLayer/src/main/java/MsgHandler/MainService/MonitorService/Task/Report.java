package MsgHandler.MainService.MonitorService.Task;

import Adapter.MongoDB.MongoDB;
import MsgHandler.MainService.MonitorService.Task.Task;
import Tool.JSONTool;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Report implements Task {

    private static Logger logger = Logger.getRootLogger();

    public String doTask(String msg) {

        logger.debug("Monitor Report start with msg - " + msg);

        // singleton mongodb
        MongoDB mongo = MongoDB.getMongoDB();

        String id = JSONTool.getValueFromString(msg, "id");
        ArrayList<Object> result = mongo.query("Device", "id", id);

        if (result.size() != 1) {
            logger.error("Device count is not equal to one - Deivce ID - " + id);
            // raise a error j
            return "Failed";
        } else if (mongo.add("Monitor", msg)) {
            // insert a item
            return "";
        }

        // access db failed
        return "Failed";

    }

}