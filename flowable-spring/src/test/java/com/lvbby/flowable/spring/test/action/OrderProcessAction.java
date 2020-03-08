package com.lvbby.flowable.spring.test.action;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 *
 * @author dushang.lp
 * @version $Id: InitAction.java, v 0.1 2020年03月06日 21:37 dushang.lp Exp $
 */
@Component
public class OrderProcessAction implements AbstractOrderAction {
    @Override
    public void invoke(OrderContext context) {
        OrderDTO order = context.getValue("order");
        if(order==null || !order.getStatus().equals("init")){
            throw new RuntimeException("order is null or status invalid");
        }
        order.setStatus("finished");
        System.out.println("finish order: " + JSON.toJSONString(order,true));
    }

}