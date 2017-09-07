package MQ.CustomizeMQ.Producer.MQProducer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableProducer;
import MQ.RabbitMQ.Producer.NonFeedbackProducer;
import Tool.JSONTool;

import static spark.Spark.port;
import static spark.Spark.post;

public class Monitor implements MQProducer {

    @Override
    public void launchProducer(String[] args) {
        port(8082);

        LaunchableProducer producer = new NonFeedbackProducer(args);
        post("report", (req, res) -> {
            try {
                String msg = req.body();

                // add action name for consumer
                msg = JSONTool.addKeyValueToString(msg, "task", "Report");

                // filter invalid format
                if (Tool.JSONTool.getValueFromString(msg, "id") == "")
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
