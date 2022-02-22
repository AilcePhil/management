package com.zzyycc.modules.generator.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className MgGeneratorCodeDTO
 * @createTime 2022/2/22 14:13
 * @description
 */
public class MgGeneratorCodeDTO implements Serializable {
    private static final long serialVersionUID = 2819433445126313250L;

    @ApiModelProperty(value = "数据库名称")
    private String databaseName;

    @Schema(name = "表名")
    private String tableName;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
