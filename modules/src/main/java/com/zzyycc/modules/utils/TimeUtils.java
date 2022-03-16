package com.zzyycc.modules.utils;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author zhuyuechao
 * @version 1.0.0
 * @className TimeUtils
 * @createTime 2022/3/16 11:25
 * @description
 */
public class TimeUtils {

    public static LocalDateTime dateToLocalDateTime(@NotNull Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
