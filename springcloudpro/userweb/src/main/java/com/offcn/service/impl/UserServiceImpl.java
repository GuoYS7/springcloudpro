package com.offcn.service.impl;

import com.netflix.discovery.converters.Auto;
import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    //创建一个 远程服务调用客户端 用来调用远程服务中的方法
    @Autowired
    private RestTemplate restTemplate;

    //Eureka 客户端
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    //获取已经发布的远程服务提供者
    public String getProviderService(){
        //注册中新的 提供者的名字
        ServiceInstance userprovider = loadBalancerClient.choose("USERPROVIDER");
        //获取提供者服务的ip地址
        String ID = userprovider.getHost();
        //获取提供者服务的端口号
        int port = userprovider.getPort();

        //拼接实际提供者服务的地址
        return "http://"+ID+":"+port+"/users";
    }


    //新增
    @Override
    public void saveInfo(User user) {
        restTemplate.postForObject(getProviderService()+"/",user,String.class);
    }
    //查询所以
    @Override
    public Map<String, Object> findAll() {

        return restTemplate.getForObject(getProviderService()+"/",Map.class);
    }

    @Override
    public User findOne(Long id) {
        return restTemplate.getForObject(getProviderService()+"/"+id,User.class);
    }

    @Override
    public void updateInfo(User user) {
        restTemplate.put(getProviderService()+"/",user);
    }

    @Override
    public void deleteInfo(Long id) {
        restTemplate.delete(getProviderService()+"/"+id);
    }
}
