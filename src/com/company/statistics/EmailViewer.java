package com.company.statistics;

import java.util.ArrayList;
import java.util.List;

public class EmailViewer implements StatViewer{
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailViewer();
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        //TODO
    }
}
