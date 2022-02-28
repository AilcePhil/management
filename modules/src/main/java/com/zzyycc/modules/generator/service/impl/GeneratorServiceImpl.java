package com.zzyycc.modules.generator.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;
import com.zzyycc.modules.generator.service.GeneratorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className GeneratorServiceImpl
 * @createTime 2022/2/22 14:25
 * @description
 */
@Component
public class GeneratorServiceImpl implements GeneratorService {

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;

    private final StringRedisTemplate stringRedisTemplate;

    public GeneratorServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void generatorCode(MgGeneratorCodeDTO dto) {
        fastAutoGenerator(dto).execute();

    }

    @Override
    public void downloadCode(MgGeneratorCodeDTO dto, HttpServletResponse response) {
        this.generatorCode(dto);
        // 读取文件
        String path = this.getSystemPath();

        String headerType = "Content-disposition";
        String fileName = "code" + ".zip";
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Access-Control-Expose-Headers", headerType);
        response.setContentType("application/octet-stream");
        // 表示不能用浏览器直接打开
        response.setHeader("Connection", "close");
        // 告诉客户端允许断点续传多线程连接下载
        response.setHeader("Accept-Ranges", "bytes");
        response.setCharacterEncoding("UTF-8");
        response.setHeader(headerType, "attachment; filename=\"" + fileName + "\"");
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private String getSystemPath() {
        return System.getProperty("os.name").toLowerCase().contains("windows") ? "D://AutoGenerator" : "/tmp/AutoGenerator";
    }


    private FastAutoGenerator fastAutoGenerator(MgGeneratorCodeDTO dto) {
        return FastAutoGenerator.create(
                new DataSourceConfig.Builder(url, username, password)
                        .typeConvert(new MySqlTypeConvert()).keyWordsHandler(new MySqlKeyWordsHandler()))
                .globalConfig(builder -> builder
                        .fileOverride()
                        .outputDir(getSystemPath())
                        .author(StringUtils.isNotEmpty(dto.getAuthor()) ? dto.getAuthor() : "zyc")
                        .enableSwagger()
                        .dateType(DateType.TIME_PACK).commentDate("yyyy-MM-dd HH:mm:ss")
                        .build())
                .packageConfig(builder -> builder
                        .parent(StringUtils.isNotEmpty(dto.getParent()) ? dto.getParent() : "com.zzyycc")
                        .moduleName(StringUtils.isNotEmpty(dto.getModuleName()) ? dto.getModuleName() : "")
                        .entity("entity")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .controller("controller")
                        .other("other")
                        .build())
                .templateConfig(builder -> builder
                        // 禁用所用模板，启用自己的配置模板
                        .disable()
                        .entity("/templates/myEntity.java")
                        .service("/templates/myService.java")
                        .serviceImpl("/templates/myServiceImpl.java")
                        .mapper("/templates/myMapper.java")
                        .mapperXml("/templates/myMapper.xml")
                        .controller("/templates/myController.java")
                        .build())
                .strategyConfig(builder -> builder
                        .enableSkipView()
                        .addInclude(dto.getTableNameList())
                        .build()
                        // entity配置
                        .entityBuilder().enableActiveRecord()
                        .enableColumnConstant()
                        .enableRemoveIsPrefix()
                        //.enableTableFieldAnnotation()
                        .naming(NamingStrategy.underline_to_camel)
                        // controller配置
                        .controllerBuilder().enableRestStyle()
                        // service配置
                        .serviceBuilder().superServiceClass(IService.class).superServiceImplClass(ServiceImpl.class)
                        .convertServiceFileName(entityName -> entityName + ConstVal.SERVICE)
                        // mapper配置
                        .mapperBuilder().superClass(BaseMapper.class).enableMapperAnnotation().enableBaseResultMap()
                        .enableBaseColumnList()
                .build());
    }
}
