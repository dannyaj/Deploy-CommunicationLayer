package MsgHandler.MainService.DeviceManagerService.Task;

import Adapter.MongoDB.MongoDB;
import Tool.JSONTool;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Register implements Task {

    private static Logger logger = Logger.getRootLogger();

    public String doTask(String msg) {
        // return "" means success

        logger.debug("Device Register start with msg - " + msg);

        // singleton mongodb
        MongoDB mongo = MongoDB.getMongoDB();
        String collectionName = "Device";

        String id = JSONTool.getValueFromString(msg, "id");
        ArrayList<Object> result = mongo.query(collectionName,"id", id);

        if (result.size() == 1 && mongo.update(collectionName,"id", id, msg)) {
            // update item if item exist
            return "";
        } else if (mongo.add(collectionName, msg)) {
            // insert item if item doesn't exist
            return "";
        }

        // access db failed
        return "Failed";

    }

}
