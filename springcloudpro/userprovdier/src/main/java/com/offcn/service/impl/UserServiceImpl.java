package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveInfo(User user) {
        userDao.save(user);
    }

    @Override
    public Map<String,Object> findAll() {
        Map<String,Object> map = new HashMap();
        List<User> all = userDao.findAll();
        map.put("list",all);
        map.put("version","用户服务 UserProvdier001:0.01V");
        return map;
    }

    @Override
    public User findOne(Long id) {

        return userDao.findById(id).get();
    }

    @Override
    public void updateInfo(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public void deleteInfo(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public Slice<User> searchUser(Pageable pageable) {
        return userDao.findAll(pageable);
    }
}
