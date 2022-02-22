package com.zzyycc.modules.generator.service;

import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;

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
     * @param dto
     */
    void generatorCode(MgGeneratorCodeDTO dto);
}
