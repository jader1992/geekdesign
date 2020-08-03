package com.company.ioc;

public abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("Test successd.");
        } else {
            System.out.println("Test failed.");
        }
    }

    public abstract boolean doTest();
}
