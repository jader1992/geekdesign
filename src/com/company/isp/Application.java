package com.company.isp;

public class Application {
    ConfigSource configSource = new ZookeeperConfigSource();
    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(configSource);
    public static final MysqlConfig mysqlConfig = new MysqlConfig(configSource);
    public static final ApiMetrics apiMetrics = new ApiMetrics();
    public static  final DbMetrics dbMetrics = new DbMetrics();

    public static void main(String[] args) {
        ScheduleUpdater redisConfigUpdater  = new ScheduleUpdater(redisConfig, 300, 300);
        redisConfigUpdater.run();

        ScheduleUpdater KafkaConfigUpdater = new ScheduleUpdater(kafkaConfig,60,300);
        KafkaConfigUpdater.run();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1",2389);
        simpleHttpServer.addViewers("/config",redisConfig);
        simpleHttpServer.addViewers("/config",mysqlConfig);
        simpleHttpServer.addViewers("/metrics",apiMetrics);
        simpleHttpServer.addViewers("/metrics",dbMetrics);
        simpleHttpServer.run();
    }
}
