package com.blog.utils;

import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @className: StringUtils
 * @description: 字符串工具类
 * @auther: huangfu
 * @Date: 2019/6/4
 * @Version: 1.1
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    private static final Pattern PATTERN = Pattern.compile(".*.(\\[.*\\])");
    /**
     * 将权限信息转换为格式化字符串
     * @param msg 要转换的字符串
     */
    public static String getPermissionData(String msg){
        Matcher matcher = PATTERN.matcher(msg);
        if(matcher.find()){
            return "权限不足，请联系管理员！"+matcher.group(1);
        }
        return msg;
    }


}
