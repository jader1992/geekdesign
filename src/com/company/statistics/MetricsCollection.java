package com.company.statistics;

import com.sun.tools.javac.util.StringUtils;

public class MetricsCollection {

    private MetricsStorage metricsStorage; //基于接口而非实现编程

    public MetricsCollection(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return ;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
