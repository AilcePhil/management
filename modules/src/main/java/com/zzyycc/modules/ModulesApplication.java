package com.zzyycc.modules;

import com.zzyycc.common.swagger.annotation.EnableMgSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableMgSwagger2
public class ModulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModulesApplication.class, args);
    }

}
