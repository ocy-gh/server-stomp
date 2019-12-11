package com.example.server.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.server.entity.po.Greeting;
import com.example.server.entity.po.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "true")
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

//    @PostMapping("/callback")
//    @ResponseBody
//    public JSONObject callback(@RequestBody JSONObject requestBodyJO){
//        int[] data = {1,3,4,5};
//
//        JSONObject requestJO = new JSONObject();
//        requestBodyJO.put("data", data);
//
//        System.out.println(requestJO.toString());
//        return requestJO;
//    }
}