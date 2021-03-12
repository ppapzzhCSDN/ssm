package com.zzh.exceptions;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zzh
 * @description
 * @date
 */
//全局异常
//@ControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(Exception.class)
    public String Exception(Exception e) {
        //跳转错误页面
        return "error";
    }

}
