package MQ.CustomizeMQ.Producer.MQProducer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableProducer;
import MQ.RabbitMQ.Producer.NonFeedbackProducer;
import Tool.JSONTool;

import static spark.Spark.port;
import static spark.Spark.post;

public class DeviceController  implements MQProducer {

    @Override
    public void launchProducer(String[] args) {
        port(8083);
        LaunchableProducer producer = new NonFeedbackProducer(args);
        post("control", (req, res) -> {
            try {
                String msg = req.body();

                // add action for consumer
                msg = JSONTool.addKeyValueToString(msg, "task", "Control");

                // filter invalid format
                if (JSONTool.getValueFromString(msg, "id") == "" ||
                        JSONTool.getValueFromString(msg, "url") == "")
                    return ApiResponses.makeBadRequest(res).body();

                // add a job to consumer
                String result = producer.sendMessage(msg);
                if (result.length() != 0)
                    return ApiResponses.makeInternalError(res, result).body();

                // success
                return ApiResponses.makeCreated(res).body();

            } catch (RuntimeException e) {
                // error
                return ApiResponses.makeInternalError(res, e.toString());
            }
        });
    }
}
