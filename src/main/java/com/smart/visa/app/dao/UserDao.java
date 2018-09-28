package com.smart.visa.app.dao;

import com.smart.visa.api.entity.UserEntity;

/**
 * @description:
 * @author: zhuxuanlin
 * @date: 2018/9/27
 */
public interface UserDao {

    int deleteByPrimaryKey(Integer userId);

    UserEntity selectByPrimaryKey(Integer userId);

    int insert(UserEntity user);
}
