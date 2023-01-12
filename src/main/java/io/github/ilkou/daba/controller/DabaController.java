package io.github.ilkou.daba.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DabaController {

    final private SimpMessagingTemplate template;

    public DabaController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @GetMapping("/daba")
    public String daba(@RequestParam(defaultValue = "Hello world") String message) {
        template.convertAndSend("/topic/daba", message);
        return message;
    }
}
