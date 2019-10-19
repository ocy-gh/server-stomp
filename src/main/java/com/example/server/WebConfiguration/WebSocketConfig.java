package com.example.server.WebConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
//        config.enableSimpleBroker("/topic", "/queue", "/user");
//        config.setApplicationDestinationPrefixes("/app");
//        config.setUserDestinationPrefix("/user");
    }

//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//
//        registry
//                .addEndpoint("/greeting")
//                .setHandshakeHandler(new DefaultHandshakeHandler() {
//
//                    public boolean beforeHandshake(
//                            ServerHttpRequest request,
//                            ServerHttpResponse response,
//                            WebSocketHandler wsHandler,
//                            Map attributes) throws Exception {
//                            if (request instanceof ServletServerHttpRequest) {
//                                ServletServerHttpRequest servletRequest
//                                        = (ServletServerHttpRequest) request;
//                                HttpSession session = servletRequest
//                                        .getServletRequest().getSession();
//                                attributes.put("sessionId", session.getId());
//                            }
//                        return true;
//                    }}).withSockJS();
//    }

}