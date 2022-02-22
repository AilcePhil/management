package com.zzyycc.modules.generator.controller;


import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;
import com.zzyycc.modules.generator.service.GeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "代码生成", description = "代码生成")
public class Generator {

    private final GeneratorService generatorService;

    public Generator(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @Operation(description = "代码生成")
    @PostMapping("/generator/code")
    public String generatorCode(@RequestBody MgGeneratorCodeDTO dto) {
        generatorService.generatorCode(dto);
        return "hello world";
    }


}
