package com.bpag.apigateway.security.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@EnableWebSocketMessageBroker
@Configuration
public class GatewayWebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private final String[] URL_WEBSOCKET = {"/sign-up","/log-in","/menu-create",
            "/menu-change-status", "/menu-delete", "menu-view", "/product-buy",
            "/product-create", "/product-delete", "/product-fill-out",
            "/product-find-by-id", "/product-list"};

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes("/request");
        registry.enableSimpleBroker(URL_WEBSOCKET);
        registry.setUserDestinationPrefix("/response");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/cafe")
                .setAllowedOriginPatterns("http://18.232.239.132/", "localhost")
                .setAllowedOrigins("http://18.232.239.132/", "http://localhost")
                .withSockJS()
                .setWebSocketEnabled(true)
                .setSessionCookieNeeded(true);
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration){
        registration.setMessageSizeLimit(2048 * 2048);
        registration.setSendBufferSizeLimit(2048 * 2048);
        registration.setSendTimeLimit(2048 * 2048);
    }

}