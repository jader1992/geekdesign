package com.company.ioc;

import java.util.ArrayList;
import java.util.List;

public class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCase.add(testCase);
    }

    public static final void main(String[] args) {
        for (TestCase case : testCases) {
            case.run();
        }
    }
}

// 注册操作还可以通过配置的方式来实现，不需要程序员显示调用register()
JunitApplication.register(new UserServiceTest());
