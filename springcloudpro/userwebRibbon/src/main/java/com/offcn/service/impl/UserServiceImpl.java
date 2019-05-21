package com.offcn.service.impl;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public Map<String, Object> findAll() {
        return restTemplate.getForObject(url,Map.class);
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
}
