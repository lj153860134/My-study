package com.lingjian.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @description: 自定义负载均衡轮询算法 接口
 * @author: Ling Jian
 * @date: 2020-04-02 11:46
 **/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);



}
