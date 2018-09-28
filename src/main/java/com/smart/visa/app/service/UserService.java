package com.smart.visa.app.service;


import com.smart.visa.api.entity.UserEntity;

import java.util.Map;
/**
 * @Author:      zhuxuanlin
 * @Date:        2018/09/27
 * @Version:     1.0.0
 * @Description: Areas服务层
 */
public interface UserService {

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public Map<String,Object> addUser(UserEntity user);

    /**
     * 根据userId删除
     * @param userId
     * @return
     */
    public int deleteUsre(Integer userId);

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    public UserEntity getShUserByUserId(Integer userId);
}
