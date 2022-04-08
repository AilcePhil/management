package com.zzyycc.modules.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author zyc
 * @since 2022-04-06
 */
@TableName("cracked_game")
@ApiModel(value = "CrackedGame", description = "CrackedGame Entity")
public class CrackedGame extends Model<CrackedGame> {

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String ACTIVATION_CODE = "activation_code";
    public static final String NAME = "name";
    public static final String TIAN_YI = "tian_yi";
    public static final String BAI_DU = "bai_du";
    public static final String PRESENT = "present";
    public static final String CREATE_TIME = "create_time";

    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 游戏编号
     */
    @ApiModelProperty("游戏编号")
    @TableField("`code`")
    private String code;

    /**
     * 激活码
     */
    @ApiModelProperty("激活码")
    private String activationCode;

    /**
     * 游戏名称
     */
    @ApiModelProperty("游戏名称")
    @TableField("`name`")
    private String name;

    /**
     * 天翼云盘
     */
    @ApiModelProperty("天翼云盘")
    private String tianYi;

    /**
     * 百度网盘
     */
    @ApiModelProperty("百度网盘")
    private String baiDu;

    /**
     * 赠品
     */
    @ApiModelProperty("赠品")
    private String present;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTianYi() {
        return tianYi;
    }

    public void setTianYi(String tianYi) {
        this.tianYi = tianYi;
    }

    public String getBaiDu() {
        return baiDu;
    }

    public void setBaiDu(String baiDu) {
        this.baiDu = baiDu;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CrackedGame{" +
        "id=" + id +
        ", code=" + code +
        ", activationCode=" + activationCode +
        ", name=" + name +
        ", tianYi=" + tianYi +
        ", baiDu=" + baiDu +
        ", present=" + present +
        ", createTime=" + createTime +
        "}";
    }
}
