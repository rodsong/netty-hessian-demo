package com.demo.pojo.impl;

/**
 * ÃèÊö
 *
 * @author songyanfei
 * @version 1.0
 * @date 2016Äê03ÔÂ16ÈÕ added
 */

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

    public String doSomething(){
        System.out.println("service do save data.");
        return "OK";
    }
}
