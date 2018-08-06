package com.smart.visa.api.vo;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
* Author:      wangjiangbo
* Date:        15:29 2018/08/06
* Version:     1.0.0
* Description: Areas数据对象
*/
@Data
public class AreasVo implements Serializable {

    public AreasVo() {
    }


    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Integer areaId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private Integer level;

    /**
     * 
     */
    private Integer fatherId;

    /**
     * 
     */
    private String areaCode;

    /**
     * 
     */
    private Date createAt;

    /**
     * 
     */
    private Long createBy;

    /**
     * 
     */
    private String createName;

    /**
     * 
     */
    private Date updateAt;

    /**
     * 
     */
    private Long updateBy;

    /**
     * 
     */
    private String updateName;


}
