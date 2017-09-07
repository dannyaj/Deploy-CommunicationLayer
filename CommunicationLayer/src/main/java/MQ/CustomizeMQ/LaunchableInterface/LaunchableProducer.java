package MQ.CustomizeMQ.LaunchableInterface;

import java.io.IOException;

public interface LaunchableProducer {
    public String sendMessage(String msg) throws IOException, InterruptedException;
}
