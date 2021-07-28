package com.lingjian.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-03-23 14:51
 **/
@ConfigurationProperties(prefix ="com.lingjian.hello")
public class HelloProperties {
    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
