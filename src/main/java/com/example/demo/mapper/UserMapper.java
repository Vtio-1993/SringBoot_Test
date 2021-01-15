package com.example.demo.mapper;

import com.example.demo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    UserBean getInfo(String name,String password);
}
