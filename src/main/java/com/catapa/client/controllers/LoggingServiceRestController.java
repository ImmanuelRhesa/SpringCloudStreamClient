package com.catapa.client.controllers;

import com.catapa.client.channels.LoggingChannel;
import com.catapa.client.entity.Log;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/log-service")
public class LoggingServiceRestController {

    private final MessageChannel channel;

    public LoggingServiceRestController(LoggingChannel channel) {
        this.channel = channel.output();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void write() {
        HashMap<String, String> map = new HashMap<>();
        map.put("to", "irheza@live.com");
        map.put("emailType", "FORGOT_PASSWORD");
        this.channel.send(MessageBuilder.withPayload(map).build());
    }
}
