package com.bpag.apigateway.web.controllers;

import com.bpag.apigateway.web.rabbit.IRabbitMQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GateWayController {

    @Autowired
    private IRabbitMQ rabbitMQ;

    @MessageMapping("/sign-up")
    private void signUp(String request){
        rabbitMQ.sendToUserSignUpQueue(request);
    }

    @MessageMapping("/log-in")
    private void logIn(String request){
        rabbitMQ.sendToUserLogInQueue(request);
    }

    @MessageMapping("/menu-create")
    private void menuCreate(String request){
        rabbitMQ.sendToMenuCreateQueue(request);
    }

    @MessageMapping("/menu-change-status")
    private void menuChangeStatus(String request){
        rabbitMQ.sendToMenuChangeStatusQueue(request);
    }

    @MessageMapping("/menu-delete")
    private void menuDelete(String request){
        rabbitMQ.sendToMenuDeleteQueue(request);
    }

    @MessageMapping("/menu-view")
    private void menuView(String request){
        rabbitMQ.sendTOMenuView(request);
    }

    @MessageMapping("/product-buy")
    private void productBuy(String request){
        rabbitMQ.sendToProductBuyQueue(request);
    }

    @MessageMapping("/product-create")
    private void productCreate(String request){
        rabbitMQ.sendToProductCreateQueue(request);
    }

    @MessageMapping("/product-delete")
    private void productDelete(String request){
        rabbitMQ.sendToProductDeleteQueue(request);
    }

    @MessageMapping("/product-fill-out")
    private void productFillOut(String request){
        rabbitMQ.sendToProductFillOutQueue(request);
    }

    @MessageMapping("/product-find-by-id")
    private void productFindById(String request){
        rabbitMQ.sendToProductFindByIdQueue(request);
    }

    @MessageMapping("/product-list")
    private void productList(String request){
        rabbitMQ.sendToProductListQueue(request);
    }

}
