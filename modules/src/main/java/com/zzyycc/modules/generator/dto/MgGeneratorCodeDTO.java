package com.zzyycc.modules.generator.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

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

    @ApiModelProperty(name = "表名列表")
    private List<String> tableNameList;


    @ApiModelProperty(name = "作者名")
    private String author;

    @ApiModelProperty(name = "父包名")
    private String parent;

    @ApiModelProperty(name = "模块名")
    private String moduleName;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public List<String> getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(List<String> tableNameList) {
        this.tableNameList = tableNameList;
    }

    @Override
    public String toString() {
        return "MgGeneratorCodeDTO{" +
                "databaseName='" + databaseName + '\'' +
                ", tableNameList=" + tableNameList +
                ", author='" + author + '\'' +
                ", parent='" + parent + '\'' +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }
}
