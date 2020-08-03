package com.company.di;

public class Application {
    MessageSender messageSender = new MessageSender();
    Notification notification = new Notification(messageSender);
}
