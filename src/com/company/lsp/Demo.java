package com.company.lsp;

public class Demo {
    public Demo(String name){
        //这个构造器仅有一个参数：name
        System.out.println("小狗的名字是 : " + name );
    }
    public void demoFunction(Transporter transporter) {
        Request request = new Request();
        //...省略设置request中数据值的代码...
        Response response = transporter.SendRequest(request);
    }
}

