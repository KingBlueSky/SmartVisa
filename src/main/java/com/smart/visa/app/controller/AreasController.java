package com.smart.visa.app.controller;

import com.smart.visa.api.entity.AreasEntity;
import com.smart.visa.api.vo.AreasVo;
import com.smart.visa.app.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
* @Author:      wangjiangbo
* @Date:        15:29 2018/08/06
* @Version:     1.0.0
* @Description: Areas控制层
*/
@RestController
@RequestMapping("areas")
public class AreasController {

    @Autowired
    private AreasService areasService;

    /**
    * 保存Areas
    * @return
    */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void saveAreas(@Valid @RequestBody AreasVo areasVo) {

        AreasEntity areasEntity = new AreasEntity();
        areasEntity.setId(areasVo.getId());
        areasEntity.setAreaId(areasVo.getAreaId());
        areasEntity.setName(areasVo.getName());
        areasEntity.setCode(areasVo.getCode());
        areasEntity.setLevel(areasVo.getLevel());
        areasEntity.setFatherId(areasVo.getFatherId());
        areasEntity.setAreaCode(areasVo.getAreaCode());
        areasEntity.setCreateAt(areasVo.getCreateAt());
        areasEntity.setCreateBy(areasVo.getCreateBy());
        areasEntity.setCreateName(areasVo.getCreateName());
        areasEntity.setUpdateAt(areasVo.getUpdateAt());
        areasEntity.setUpdateBy(areasVo.getUpdateBy());
        areasEntity.setUpdateName(areasVo.getUpdateName());

        areasService.save(areasEntity);

    }


    /**
     * 查询Areas列表
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<AreasEntity> queryAreasList(AreasVo areasVo) {

        AreasEntity param = new AreasEntity();
        param.setId(areasVo.getId());
        param.setAreaId(areasVo.getAreaId());
        param.setName(areasVo.getName());
        param.setCode(areasVo.getCode());
        param.setLevel(areasVo.getLevel());
        param.setFatherId(areasVo.getFatherId());
        param.setAreaCode(areasVo.getAreaCode());
        param.setCreateAt(areasVo.getCreateAt());
        param.setCreateBy(areasVo.getCreateBy());
        param.setCreateName(areasVo.getCreateName());
        param.setUpdateAt(areasVo.getUpdateAt());
        param.setUpdateBy(areasVo.getUpdateBy());
        param.setUpdateName(areasVo.getUpdateName());
        return areasService.findByParam(param);
    }

}
