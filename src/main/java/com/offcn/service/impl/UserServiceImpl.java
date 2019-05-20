package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void saveInfo(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Long id) {
       return userDao.getOne(id);
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
    public Slice<User> searchUser(String name,Pageable pageable) {
        return userDao.findAll(pageable);
        //return userDao.findByUsernameContaining(name,pageable);
    }
}
