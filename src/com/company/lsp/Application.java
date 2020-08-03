package com.company.lsp;

public class Application {
    public static void main() {
        Demo test = new Demo("test");
        test.demoFunction(new SecurityTransporter());
    }
}
