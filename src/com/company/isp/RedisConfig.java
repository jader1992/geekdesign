package com.company.isp;

public class RedisConfig implements Updater,Viewer{
    @Override
    public void update() { }

    @Override
    public String outputInPlainText() { }

    @Override
    public Map<String, String> output() { }
}
