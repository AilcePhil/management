package com.zzyycc.common.swagger.config;

import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className WebFluxSwaggerConfiguration
 * @createTime 2022/2/23 10:45
 * @description webflux 网关 swagger 资源路径配置
 */
public class WebFluxSwaggerConfiguration implements WebFluxConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }
}
