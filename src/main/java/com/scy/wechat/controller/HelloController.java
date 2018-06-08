package com.scy.wechat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名： hello <br>
 * 描述：TODO <br>
 * 创建日期： 2018/3/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world!";
    }

}
