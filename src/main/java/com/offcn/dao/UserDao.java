package com.offcn.dao;

import com.offcn.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    public User findByUsernameAndPassword(String username,String password);

    //分页查询
    public Slice<User> findByUsernameContaining(String username,Pageable pageable);

}
