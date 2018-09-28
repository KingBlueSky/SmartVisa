package com.smart.visa.app.service.impl;

import com.smart.visa.api.entity.UserEntity;
import com.smart.visa.app.dao.UserDao;
import com.smart.visa.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * zhuxuanlin
 *
 * @EMAIL:SHENGMIAO@HKRT.CN
 * @Description: <br/>
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2018/9/27      zhuxuanlin          1.0             1.0
 */
@Service
public class UserServiecImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiecImpl.class);

    @Autowired
    private UserDao userResultMapper;

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public Map<String, Object> addUser(UserEntity user) {

        Map<String, Object> returnMap = new HashMap<String, Object>();
        UserEntity users = new UserEntity();
        users.setName("lihongwei");
        user.setPassword("123456");
        returnMap.put("users",users);

        return returnMap;
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public int deleteUsre(Integer userId) {
        return userResultMapper.deleteByPrimaryKey(userId);
    }

    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
    public UserEntity getShUserByUserId(Integer userId) {
        return userResultMapper.selectByPrimaryKey(userId);
    }
}
