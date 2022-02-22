package com.zzyycc.modules.generator.service.impl;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.zzyycc.modules.generator.dto.MgGeneratorCodeDTO;
import com.zzyycc.modules.generator.service.GeneratorService;
import org.springframework.stereotype.Component;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className GeneratorServiceImpl
 * @createTime 2022/2/22 14:25
 * @description
 */
@Component
public class GeneratorServiceImpl implements GeneratorService {


    @Override
    public void generatorCode(MgGeneratorCodeDTO dto) {

        createDataSource(dto);

    }


    private void createDataSource(MgGeneratorCodeDTO dto) {

        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(
                new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/" + dto.getDatabaseName(), "root", "123456")
                        .typeConvert(new MySqlTypeConvert()).keyWordsHandler(new MySqlKeyWordsHandler()));

        new GlobalConfig.Builder().fileOverride();


    }
}
