package com.smart.visa.app.dao;


import com.smart.visa.api.entity.AreasEntity;

import java.util.List;

/**
* @Author:      wangjiangbo
* @Date:        15:29 2018/08/06
* @Version:     1.0.0
* @Description: Areas数据访问对象
*/
public interface AreasDao {

    /**
     * 保存
     * @param areasEntity
     * return
     */
    Long save(AreasEntity areasEntity);

    /**
     * 更新
     * @param areasEntity
     * return
     */
    int update(AreasEntity areasEntity);

    /**
     * 按条件查询
     * @param areasEntity
     * return
     */
    List<AreasEntity> findByParam(AreasEntity areasEntity);

}
