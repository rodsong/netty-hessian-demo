package com.demo.pojo.impl;

/**
 * ����
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016��03��16�� added
 */

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

    public String doSomething(){
        System.out.println("service do save data.");
        return "OK";
    }
}
