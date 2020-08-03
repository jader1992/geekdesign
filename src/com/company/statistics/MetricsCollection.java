package com.company.statistics;

import com.sun.tools.javac.util.StringUtils;

public class MetricsCollection {

    private MetricsStorage metricsStorage; //基于接口而非实现编程

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE = 20);
    }

    public MetricsCollection(MetricsStorage metricsStorage,int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return ;
        }
        eventBus.post(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
}
