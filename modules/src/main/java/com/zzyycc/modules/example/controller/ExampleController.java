package com.zzyycc.modules.example.controller;

import com.zzyycc.common.core.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className ExampleController
 * @createTime 2022/4/8 16:23
 * @description
 */
@RestController
@RequestMapping("/example")
@Api(value = "example", tags = "示例")
public class ExampleController {


    @ApiOperation(value = "爬数据")
    @PostMapping("/netdata")
    public ResponseData<Void> netData() {





        return ResponseData.success();
    }


}
