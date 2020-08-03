package com.company.di;

public class Notification {
    private MessageSender messageSender;

    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message) {
        // ...省略校验逻辑等...
        this.messageSender.send(cellphone, message);
    }
}
