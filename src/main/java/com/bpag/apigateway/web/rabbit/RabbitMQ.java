package com.bpag.apigateway.web.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ implements IRabbitMQ{

    @Autowired
    private RabbitTemplate template;

    @Override
    public void sendToUserSignUpQueue(String request) {
        template.convertAndSend("queue.users_sign_up", request);
    }

    @Override
    public void sendToUserLogInQueue(String request) {
        template.convertAndSend("queue queue.users_log_in");
    }

    @Override
    public void sendToMenuCreateQueue(String request) {
        template.convertAndSend("queue.menus_create", request);
    }

    @Override
    public void sendToMenuChangeStatusQueue(String request) {
        template.convertAndSend("queue.menus_change_status", request);
    }

    @Override
    public void sendToMenuDeleteQueue(String request) {
        template.convertAndSend("queue.menus_delete", request);
    }

    @Override
    public void sendTOMenuView(String request) {
        template.convertAndSend("queue.menus_view", request);
    }

    @Override
    public void sendToProductBuyQueue(String request) {
        template.convertAndSend("queue.products_buy", request);
    }

    @Override
    public void sendToProductCreateQueue(String request) {
        template.convertAndSend("queue.products_create", request);
    }

    @Override
    public void sendToProductDeleteQueue(String request) {
        template.convertAndSend("queue.products_delete", request);
    }

    @Override
    public void sendToProductFillOutQueue(String request) {
        template.convertAndSend("queue.products_fill_out", request);
    }

    @Override
    public void sendToProductFindByIdQueue(String request) {
        template.convertAndSend("queue.products_find_one_by_id", request);
    }

    @Override
    public void sendToProductListQueue(String request) {
        template.convertAndSend("queue.products_list", request);
    }

}
