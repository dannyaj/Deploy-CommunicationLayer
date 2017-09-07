package RestfulClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class PrivateHttpClient implements RestfulClient {

    static public RestfulResponse get(String url) {
        return new RestfulResponse(0, "");
    }

    static public RestfulResponse post(String url, String body) throws IOException {

        int timeoutSec = 1;

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeoutSec * 1000).build();

        HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
        HttpPost request = new HttpPost(url);

        request.addHeader("ContentType", "application/json");

        StringEntity entity = new StringEntity(body);
        request.setEntity(entity);

        HttpResponse response = client.execute(request);

        int responseCode = response.getStatusLine().getStatusCode();

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer content = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            content.append(line);
        }

        return new RestfulResponse(responseCode, content.toString());
    }
}
