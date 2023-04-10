package com.bpag.apigateway.web.controllers;

import com.bpag.apigateway.security.configurations.GatewayBasicResponseConfiguration;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class GateWayResponseController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private GatewayBasicResponseConfiguration baseResponse;

    @RabbitListener(queues = {"queue.users_sign_up_responses","queue.users_sign_up_errors"})
    public void userSignUpResponse(String payload) throws IOException {
        BaseResponse response = baseResponse.baseResponse(payload);
        template.convertAndSendToUser(response.getSessionId(), "/sign-up", payload);
    }

    @RabbitListener(queues = {"queue.users_log_in_response", "queue.users_log_in_errors"})
    public void userLogInResponse(String payload) throws IOException {
        BaseResponse response = baseResponse.baseResponse(payload);;
        template.convertAndSendToUser(response.getSessionId(), "/log-in", payload);
    }

    @RabbitListener(queues = {"queue.menus_create_response", "queue.menus_create_errors"})
    public void menuCreate(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        template.convertAndSendToUser(sessionId, "/menu-create", payload);
    }

    @RabbitListener(queues = {"queue.menus_change_status_response", "queue.menus_change_status_errors"})
    public void menuChangeStatus(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        template.convertAndSendToUser(sessionId, "/menu-change-status", payload);
    }

    @RabbitListener(queues = "queue.menus_view_response")
    public void menuView(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();;
        if(sessionId != null)
            template.convertAndSendToUser(sessionId, "menu-view", payload);
        else
            template.convertAndSend("/menu/view", payload);
    }

    @RabbitListener(queues = {"queue.products_create_response","queue.products_create_errors"})
    public void productCreate(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        template.convertAndSendToUser(sessionId, "/product-create", payload);
    }

    @RabbitListener(queues = {"queue.products_create_response", "queue.products_buy_errors"})
    public void productBuy(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        template.convertAndSendToUser(sessionId, "/product-buy", payload);
    }

    @RabbitListener(queues = {"queue.products_fill_out_response", "queue.products_fill_out_errors"})
    public void productFillOut(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        template.convertAndSendToUser(sessionId, "/product-fill-out", payload);
    }

    @RabbitListener(queues = {"queue.products_find_by_id_response", "queue.products_find_by_id_errors"})
    public void productFindById(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        if(sessionId != null){
            template.convertAndSendToUser(sessionId, "/product-find-by-id", payload);
        } else {
            template.convertAndSend("/product-find-by-id", payload);
        }
    }

    @RabbitListener(queues = "queue.products_list_response")
    public void productList(String payload) throws IOException{
        String sessionId = baseResponse.baseResponse(payload).getSessionId();
        if(sessionId != null){
            template.convertAndSendToUser(sessionId, "/product-list", payload);
        } else {
            template.convertAndSend("/product-list", payload);
        }
    }

}
