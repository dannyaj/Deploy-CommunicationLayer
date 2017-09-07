package RestfulClient;

public class RestfulResponse {
    private int statusCode;
    private String body;

    public RestfulResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getBody() {
        return this.body;
    }
}
