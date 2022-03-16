package com.zzyycc.modules.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className WebConfig
 * @createTime 2022/3/16 16:56
 * @description
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
    }
}
