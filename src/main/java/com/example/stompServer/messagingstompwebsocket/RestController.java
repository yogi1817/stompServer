package com.example.stompServer.messagingstompwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private GreetingController greetingController;

    @GetMapping
    public ResponseEntity<String> sendMessage() throws Exception {
        greetingController.broadcastNews("Sending news");
        return ResponseEntity.ok("Message Broad casted");
    }
}
