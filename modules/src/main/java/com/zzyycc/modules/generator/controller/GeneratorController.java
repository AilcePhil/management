package com.zzyycc.modules.generator.controller;


import com.zzyycc.common.core.utils.ResponseData;
import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;
import com.zzyycc.modules.generator.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
public class GeneratorController {

    private final GeneratorService generatorService;

    public GeneratorController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @ApiOperation(value = "代码生成")
    @PostMapping("/create/code")
    public ResponseData<Void> generatorCode(@RequestBody MgGeneratorCodeDTO dto) {
        generatorService.generatorCode(dto);
        return ResponseData.success();
    }

    @ApiOperation(value = "下载生成")
    @GetMapping("/download/code")
    public ResponseData<Void> downloadCode(@RequestBody MgGeneratorCodeDTO dto, HttpServletResponse response) {
        generatorService.downloadCode(dto, response);
        return ResponseData.success();
    }




}
