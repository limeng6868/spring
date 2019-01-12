package com.it.springaopdatasource.controller;


import com.it.springaopdatasource.dao.dataSource1.UserMapper1;
import com.it.springaopdatasource.dao.dataSource2.UserMapper2;
import com.it.springaopdatasource.datasource.TargetDataSource;
import com.it.springaopdatasource.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author limeng
 */
@Controller
@RequestMapping
public class ApiController {
    final static Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    UserMapper1 userMapper1;

    @Autowired
    UserMapper2 userMapper2;


    public Object getDs1(){

        List<User> userList = userMapper1.findUserList();
        logger.info(String.valueOf(userList.get(0)));
        return null;
    }

    @TargetDataSource("dataSource2")
    public Object getDs2(){
        User user = userMapper2.findByName(userMapper2.findUserList().get(0).getUsername());
        logger.info(user.toString());
        return null;
    }
}