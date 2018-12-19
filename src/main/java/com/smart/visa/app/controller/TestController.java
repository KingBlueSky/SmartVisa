package com.smart.visa.app.controller;

import com.smart.visa.common.exception.BaseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 王江波
 * @Date: 11:43 08/06/2018
 * @Version: 1.0
 * @Description: test
 */

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("bad")
    public String bad() {
        throw new BaseException(400, "bad request");
    }

    @GetMapping("say")
    public String say(String name) {

        return "say: " + name;
    }

}
