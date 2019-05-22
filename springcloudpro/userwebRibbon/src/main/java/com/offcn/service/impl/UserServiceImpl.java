package com.offcn.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //创建一个 远程服务调用客户端 用来调用远程服务中的方法
    @Autowired
    private RestTemplate restTemplate;

    //开启ribbo后 RestTemplate 直接使用服务名就可以发起调用
    String url = "http://USERPROVIDER/users/";

    //新增
    @Override
    public void saveInfo(User user) {
        restTemplate.postForObject(url,user,String.class);
    }
    //查询所以
    @Override
    @HystrixCommand(fallbackMethod = "getUserMapFallbackMethod")
    public Map<String, Object> findAll() {
        Long start = System.currentTimeMillis();
        Map forObject = restTemplate.getForObject(url, Map.class);
        long end = System.currentTimeMillis();
        System.out.println("所用时间"+(end-start));
        return forObject;

    }

    @Override
    public User findOne(Long id) {
        return restTemplate.getForObject(url+id,User.class);
    }

    @Override
    public void updateInfo(User user) {
        restTemplate.put(url,user);
    }

    @Override
    public void deleteInfo(Long id) {
        restTemplate.delete(url+id);
    }

    //创建一个方法 做熔断回滚方法
    public Map<String, Object> getUserMapFallbackMethod(){
        Map<String,Object> map = new HashMap<>();
        map.put("list",new ArrayList<>());
        map.put("version","链接超时 已启动熔断");
        return map;
    }
}
