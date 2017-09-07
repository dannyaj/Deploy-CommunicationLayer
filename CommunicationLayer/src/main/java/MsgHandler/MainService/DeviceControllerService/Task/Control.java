package MsgHandler.MainService.DeviceControllerService.Task;

import RestfulClient.PrivateHttpClient;
import RestfulClient.RestfulResponse;
import Tool.JSONTool;
import org.apache.log4j.Logger;

public class Control implements Task {

    private static Logger logger = Logger.getRootLogger();

    public String doTask(String msg) {

        logger.debug("Device Controller start with msg - " + msg);
        try {

            // get args
            String id = JSONTool.getValueFromString(msg, "id");
            String url = JSONTool.getValueFromString(msg, "url");

            // use  http client to call remote device
            RestfulResponse resp = PrivateHttpClient.post(url, msg);

            logger.info(this.getClass().getName() + " - Control " + url + " - " + resp.getStatusCode() + ", " + resp.getBody() );

            return resp.getBody();

        } catch (Exception e) {

            logger.error(this.getClass().getName() + " - " + e.toString());
            logger.error(this.getClass().getName() + " - Control Failed - " + msg.toString());

            return e.getMessage();

        }
    }
}
