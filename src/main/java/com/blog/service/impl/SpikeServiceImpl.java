package com.blog.service.impl;

import com.blog.enums.LoginEnum;
import com.blog.exceptions.BlogException;
import com.blog.service.SpikeService;
import com.blog.utils.KeyUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SpikeServiceImpl implements SpikeService {
    private static  Map<String,Integer> products;
    private static Map<String,Integer> stock;
    private static Map<String,String> orders;
    static {
        products = new HashMap<>(15);
        stock = new HashMap<>(15);
        orders = new HashMap<>(15);
        products.put("123456",100000);
        stock.put("123456",100000);
    }
    @Override
    public String queryPriduct(String productId) {
        return "国庆期间，皮蛋粥特价，限量份"+products.get(productId)+"份，"
                +"剩余："+stock.get(productId)+"份，"
                +"该商品已下单数目为"+orders.size()+"份";
    }

    @Override
    public void updateProduct(String productId) {
        Integer integer = stock.get(productId);
        if(integer<=0){
            throw new BlogException(LoginEnum.TEST);
        }else{
            //下单
            orders.put(KeyUtils.gen(),productId);
            //减库存
            integer -=1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId,integer);
        }
    }
}
