package com.catapa.client.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface LoggingChannel {

    @Output
    MessageChannel output();
}
