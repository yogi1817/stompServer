package com.example.stompServer.messagingstompwebsocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private Logger logger = LogManager.getLogger(GreetingController.class);

    @MessageMapping("/news")
    public void broadcastNews(@Payload String message) throws Exception {
        logger.info("message received "+ message);
        this.simpMessagingTemplate.convertAndSend("/topic/news", message);
        logger.info("message sent "+ message);
    }
}
