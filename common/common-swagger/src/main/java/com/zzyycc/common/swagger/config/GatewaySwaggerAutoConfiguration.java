package com.zzyycc.common.swagger.config;

import com.zzyycc.common.swagger.support.SwaggerResourceHandler;
import com.zzyycc.common.swagger.support.SwaggerSecurityHandler;
import com.zzyycc.common.swagger.support.SwaggerUiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className GatewaySwaggerAutoConfiguration
 * @createTime 2022/2/23 10:19
 * @description 网关swagger 配置类，仅在webflux 环境生效
 */

@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
@ComponentScan("com.zzyycc.common.swagger.support")
public class GatewaySwaggerAutoConfiguration {

    @Autowired
    private SwaggerResourceHandler swaggerResourceHandler;

    @Autowired
    private SwaggerSecurityHandler swaggerSecurityHandler;

    @Autowired
    private SwaggerUiHandler swaggerUiHandler;

    @Bean
    public WebFluxSwaggerConfiguration fluxSwaggerConfiguration() {
        return new WebFluxSwaggerConfiguration();
    }

    @Bean
    public RouterFunction swaggerRouterFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/swagger-resources").and(RequestPredicates.accept(MediaType.ALL)),
                        swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }
}
