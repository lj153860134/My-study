package com.lingjian.proxy;

/**
 * @description: 对生产厂家要求的接口
 * @author: Ling Jian
 * @date: 2020-02-12 17:52
 **/
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
