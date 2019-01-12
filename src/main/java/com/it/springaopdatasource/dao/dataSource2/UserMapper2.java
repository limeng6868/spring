package com.it.springaopdatasource.dao.dataSource2;


import com.it.springaopdatasource.model.User;

import java.util.List;

/**
 * @author limeng
 * @date 2019/1/12 9:29
 */
public interface UserMapper2 {
    User findByName(String name);

    List<User> findUserList();

}
