package com.smart.visa.app.service.impl;

import com.smart.visa.api.entity.AreasEntity;
import com.smart.visa.app.dao.AreasDao;
import com.smart.visa.app.service.AreasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @Author:      wangjiangbo
* @Date:        15:29 2018/08/06
* @Version:     1.0.0
* @Description: Areas服务层实现
*/
@Service("areasService")
public class AreasServiceImpl implements AreasService {

    @Autowired
    private AreasDao areasDao;

    /**
     * 保存
     * @param areasEntity
     * return
     */
    @Override
    public Long save(AreasEntity areasEntity) {
        Objects.requireNonNull(areasEntity);
        areasDao.save(areasEntity);
        return areasEntity.getId();
    }


    /**
     * 更新
     * @param areasEntity
     * return
     */
    @Override
    public int update(AreasEntity areasEntity) {
        Objects.requireNonNull(areasEntity);
        return areasDao.update(areasEntity);
    }

    /**
     * 按条件查询
     * @param areasEntity
     * return
     */
    @Override
    public List<AreasEntity> findByParam(AreasEntity areasEntity) {
        Objects.requireNonNull(areasEntity);
        return areasDao.findByParam(areasEntity);
    }


}
