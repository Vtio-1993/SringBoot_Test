package com.example.demo.service;

import com.example.demo.bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    UserBean loginIn(String name,String password);

}
