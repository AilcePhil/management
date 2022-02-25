package com.zzyycc.modules.demo;

import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;
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
    public MgGeneratorCodeDTO hello(){
        return new MgGeneratorCodeDTO();
    }
}
