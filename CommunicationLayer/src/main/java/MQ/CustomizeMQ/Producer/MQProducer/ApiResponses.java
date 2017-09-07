package MQ.CustomizeMQ.Producer.MQProducer;

import spark.Response;

public class ApiResponses {

    public static Response makeOK(Response res) {
        ApiResponses.makeOK(res, "OK");
        return res;
    }

    public static Response makeOK(Response res, String msg) {
        ApiResponses.makeOKStatus(res);
        res.body(msg);
        return res;
    }

    public static void makeOKStatus(Response res) {
        res.status(200);
    }

    public static Response makeCreated(Response res) {
        ApiResponses.makeCreated(res, "Created");
        return res;
    }

    public static Response makeCreated(Response res, String msg) {
        ApiResponses.setCreatedStatus(res);
        res.body(msg);
        return res;
    }

    public static void setCreatedStatus(Response res) {
        res.status(201);
    }

    public static Response makeBadRequest(Response res) {
        ApiResponses.makeBadRequest(res, "Bad Request");
        return res;
    }

    public static Response makeBadRequest(Response res, String msg) {
        ApiResponses.setBadRequestStatus(res);
        res.body(msg);
        return res;
    }

    public static void setBadRequestStatus(Response res) {
        res.status(400);
    }

    public static Response makeInternalError(Response res) {
        ApiResponses.makeInternalError(res, "Internal Server Error");
        return res;
    }

    public static Response makeInternalError(Response res, String msg) {
        ApiResponses.setInternalErrorStatus(res);
        res.body(msg);
        return res;
    }

    public static void setInternalErrorStatus(Response res) {
        res.status(500);
    }

}
