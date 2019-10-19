package com.example.server.Controller;

import com.example.server.entity.po.Greeting;
import com.example.server.entity.po.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @CrossOrigin(origins = "http://localhost:8080")
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
// testing testing
//    @GetMapping("/hello")
//    @SendTo("/topic/greetings")
//    public String greeting(HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return "index";
//    }

//    @GetMapping("/hello")
//    @SendTo("/topic/greetings")
//    public String greeting(HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return "index";
//    }

}