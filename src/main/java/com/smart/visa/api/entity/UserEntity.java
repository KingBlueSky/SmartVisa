package com.smart.visa.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * zhuxuanlin
 *
 * @EMAIL:SHENGMIAO@HKRT.CN
 * @Description: <br/>
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2018/9/27      zhuxuanlin          1.0             1.0
 */
@Data
public class UserEntity implements Serializable {

    private Integer userId;
    private String name;
    private String password;
    private Integer sex;

}
