package com.zzyycc.modules.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className Demo
 * @createTime 2022/2/16 10:26
 * @description
 */
@RestController()
@RequestMapping("/demo" )
public class Demo {

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld";
    }
}
