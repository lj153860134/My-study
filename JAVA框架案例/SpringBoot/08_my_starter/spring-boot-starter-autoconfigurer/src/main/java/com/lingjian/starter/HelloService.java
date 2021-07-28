package com.lingjian.starter;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-23 14:49
 **/
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name) {
        return helloProperties.getPrefix()+"-"+name+"-"+helloProperties.getSuffix();
    }

}
