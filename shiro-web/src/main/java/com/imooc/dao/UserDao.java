package com.imooc.dao;

import com.imooc.vo.User;

import java.util.List;

/**
 * @Auther: taoxd
 * @Date: 2019/4/22 10:46
 * @Description:
 */
public interface UserDao {
    User getUserByUserName(String userName);

    List<String> queryRolesByUserName(String userName);
}
