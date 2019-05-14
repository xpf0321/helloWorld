package com.breakman.cloud.exception;

import com.breakman.cloud.statusCode.IfConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ExceptionHandler(BaseException.class)
    public Map<String, Object> handlerMyException(HttpServletRequest req, BaseException e) {
        logger.error("---BaseException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        Map<String,Object> result = new HashMap<>();
        result.put("code", IfConstant.PARA_FAIL.getCode());
        result.put("message", e.getMessage());
        return result;
    }

    @ExceptionHandler(AppException.class)
    public Map<String, Object> handlerMyRuntimeException(HttpServletRequest req, AppException e) {
        logger.error("---AppException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        Map<String,Object> result = new HashMap<>();
        result.put("message", e.getMessage());
        result.put("code", IfConstant.PARA_FAIL.getCode());
        return result;
    }
}
