package MQ.CustomizeMQ.Producer.MQProducer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableProducer;
import MQ.RabbitMQ.Producer.FeedbackProducer;

import static spark.Spark.port;
import static spark.Spark.post;
import Tool.JSONTool;
import spark.Response;

public class DeviceManager implements MQProducer {

    @Override
    public void launchProducer(String[] args) {
        port(8081);
        LaunchableProducer producer = new FeedbackProducer(args);
        post("register", (req, res) -> {
            try {
                String msg = req.body();

                // add action name for consumer
                msg = JSONTool.addKeyValueToString(msg, "task", "Register");

                // filter invalid format
                if (JSONTool.getValueFromString(msg, "id") == "")
                    return ApiResponses.makeBadRequest(res).body();

                // add job to consumer
                String result = producer.sendMessage(msg);
                if (result.length() != 0)
                    return ApiResponses.makeInternalError(res, result).body();

                // success
                return ApiResponses.makeCreated(res).body();

            } catch (RuntimeException e) {
                // error
                return ApiResponses.makeInternalError(res, e.toString()).body();
            }
        });
    }


}
