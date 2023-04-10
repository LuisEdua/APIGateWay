package com.bpag.apigateway.web.rabbit;

public interface IRabbitMQ {
    void sendToUserSignUpQueue(String request);

    void sendToUserLogInQueue(String request);

    void sendToMenuCreateQueue(String request);

    void sendToMenuChangeStatusQueue(String request);

    void sendToMenuDeleteQueue(String request);

    void sendTOMenuView(String request);

    void sendToProductBuyQueue(String request);

    void sendToProductCreateQueue(String request);

    void sendToProductDeleteQueue(String request);

    void sendToProductFillOutQueue(String request);

    void sendToProductFindByIdQueue(String request);

    void sendToProductListQueue(String request);
}
