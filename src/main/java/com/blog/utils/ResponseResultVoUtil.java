package com.blog.utils;

import com.blog.vo.ResponseResultVO;

/**
 * @author 皇甫
 * 统一返回结果工具类
 */
public class ResponseResultVoUtil {


    public static ResponseResultVO success(){
        return success(null);
    }

    public static ResponseResultVO success(Object data){
        ResponseResultVO responseResultVO = new ResponseResultVO();
        responseResultVO.setCode("200");
        responseResultVO.setMsg("成功");
        responseResultVO.setT(data);
        return responseResultVO;
    }

    public static ResponseResultVO error(){
        ResponseResultVO responseResultVO = new ResponseResultVO();
        responseResultVO.setCode("500");
        responseResultVO.setMsg("未知");
        return responseResultVO;
    }

    public static ResponseResultVO failure(String code,String msg){
        ResponseResultVO responseResultVO = new ResponseResultVO();
        responseResultVO.setCode(code);
        responseResultVO.setMsg(msg);
        return responseResultVO;
    }
}
