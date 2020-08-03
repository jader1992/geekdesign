package com.company.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleReporter extends ScheduledReporter{
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;
    private ScheduledExecutorService executor;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator,StatViewer statViewer) {
        super(metricsStorage, aggregator, statViewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
                long durationInMillis = durationInSeconds * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeMIllis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeMIllis, endTimeInMillis);
                Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.output(requestStats, startTimeMIllis, endTimeInMillis);
            }
        }, 0L, periodInSeconds, TimeUnit.SECONDS);
    }
}
