package com.zzyycc.modules.generator.controller;


import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;
import com.zzyycc.modules.generator.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className Generator
 * @createTime 2022/2/21 14:31
 * @description
 */
@RestController
@RequestMapping("/generator")
@Api(value = "代码生成")
public class Generator {

    private final GeneratorService generatorService;

    public Generator(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @ApiOperation(value = "代码生成")
    @PostMapping("/generator/code")
    public String generatorCode(@RequestBody MgGeneratorCodeDTO dto) {
        generatorService.generatorCode(dto);
        return "hello world";
    }


}
