package com.company.ocp;

public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for(AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}
