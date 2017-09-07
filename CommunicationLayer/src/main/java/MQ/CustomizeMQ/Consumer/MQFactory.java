package MQ.CustomizeMQ.Consumer;

import MQ.CustomizeMQ.LaunchableInterface.LaunchableConsumer;

public interface MQFactory {
    public LaunchableConsumer createConsumer(String[] args);
}
