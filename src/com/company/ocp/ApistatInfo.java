package com.company.ocp;

public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
    private long timeoutCount;

    public void getRequestCount() {
        return this.requestCount;
    }

    public void getDutactionOfSeconds() {
        return this.durationOfSeconds;
    }


}
