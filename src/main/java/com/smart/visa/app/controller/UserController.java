package com.smart.visa.app.controller;

import com.smart.visa.api.entity.UserEntity;
import com.smart.visa.app.service.UserService;
import com.smart.visa.common.api.ApiRequest;
import com.smart.visa.common.api.ApiResponse;
import com.smart.visa.common.api.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addUser",method= RequestMethod.POST)
    @ResponseBody
    public ApiResponse addUser(@RequestBody ApiRequest apiRequest){
        ApiResponse res = new ApiResponse();
        Map<String, Object> statusMap = res.getStatus();
        Map<String, Object> responseMap = res.getResponse();
        Map<String, Object> rMap = apiRequest.getRequest();
        //Integer userId = Integer.valueOf(rMap.get("userId").toString());
        try {
            String userName = rMap.get("userName").toString();
            String passWrod = rMap.get("passWord").toString();
            String sex = rMap.get("sex").toString();

            UserEntity user =new UserEntity();
            user.setName(userName);
            user.setPassword(passWrod);
            user.setPassword(sex);
            userService.addUser(user);

            statusMap.put("code", Status.STATUS_703.getCode());
            statusMap.put("msg", Status.STATUS_703.getMsg());
        }catch (Exception e){
            logger.error("findUserByCode异常：", e);
            statusMap.put("code", Status.STATUS_999.getCode());
            statusMap.put("msg", Status.STATUS_999.getMsg());
        }
        res.setResponse(responseMap);
        res.setStatus(statusMap);
        return res;
    }

    @RequestMapping(value = "getUserId",method=RequestMethod.POST)
    @ResponseBody
    public ApiResponse getUserId(@RequestBody ApiRequest apiRequest){
        ApiResponse res = new ApiResponse();
        Map<String, Object> statusMap = res.getStatus();
        Map<String, Object> responseMap = res.getResponse();
        try{
            Map<String, Object> rMap = apiRequest.getRequest();
            Integer userId = Integer.valueOf(rMap.get("userId").toString());//当前登录人的userId
            UserEntity users = userService.getShUserByUserId(userId);

            statusMap.put("code", Status.STATUS_106.getCode());
            statusMap.put("msg", Status.STATUS_106.getMsg());
            responseMap.put("data", users);
            res.setResponse(responseMap);
        }catch(Exception e){
            logger.error("getFamilyMems异常：", e);

            statusMap.put("code", Status.STATUS_999.getCode());
            statusMap.put("msg", Status.STATUS_999.getMsg());
        }
        res.setStatus(statusMap);
        return res;
    }
}
