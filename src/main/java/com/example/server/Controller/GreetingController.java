package com.example.server.Controller;

import com.example.server.entity.po.Greeting;
import com.example.server.entity.po.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    //this is hmo testing
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    //TESTING
    @GetMapping("/ticket_registration")
    public String ticketSubmission(Model model){
        String destination = "Ticket Submission";

        model.addAttribute("destination", destination);
        return "ticket/ticket_submission";
    }

}