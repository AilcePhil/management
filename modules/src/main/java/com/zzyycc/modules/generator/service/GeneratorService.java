package com.zzyycc.modules.generator.service;

import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className GeneratorService
 * @createTime 2022/2/22 14:24
 * @description
 */
public interface GeneratorService {

    /**
     * 生成代码
     *
     * @date 2022/2/22 14:26
     * @param dto 入参
     */
    void generatorCode(MgGeneratorCodeDTO dto);

    /**
     * 下载代码
     *
     * @date 2022/2/25 14:23
     */
    void downloadCode(MgGeneratorCodeDTO dto, HttpServletResponse response);

}
