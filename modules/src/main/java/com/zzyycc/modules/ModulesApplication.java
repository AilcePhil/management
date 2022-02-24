package com.zzyycc.modules;

import com.zzyycc.common.swagger.annotation.EnableMgSwagger3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className ModulesApplication
 * @createTime 2022/2/22 14:13
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMgSwagger3
public class ModulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModulesApplication.class, args);
    }

}
