package com.zzyycc.common.swagger.annotation;

import com.zzyycc.common.swagger.config.GatewaySwaggerAutoConfiguration;
import com.zzyycc.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className EnableMgSwagger2
 * @createTime 2022/2/23 9:27
 * @description 开启mgl swagger
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableSwagger2
@EnableWebMvc
@Import({ SwaggerAutoConfiguration.class, GatewaySwaggerAutoConfiguration.class })
public @interface EnableMgSwagger2 {
}
