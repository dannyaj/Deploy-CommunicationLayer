package MsgHandler.MainService.DeviceControllerService;

import MsgHandler.MainService.DeviceControllerService.Task.TaskFactory;
import Tool.JSONTool;
import MsgHandler.MsgHandler;
import org.apache.log4j.Logger;

public class DeviceControllerService implements MsgHandler{

    private TaskFactory factory = new TaskFactory();

    private static Logger logger = Logger.getRootLogger();

    public String handleMsg(String msg) {

        // get task name
        String task = JSONTool.getValueFromString(msg, "task");

        logger.debug("DeviceController get a task - " + task);

        // call dispatcher to handle task and msg
        return this.factory.dispatcher(task, msg);
    }
}
