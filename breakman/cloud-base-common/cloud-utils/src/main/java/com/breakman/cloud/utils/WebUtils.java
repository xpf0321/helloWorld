package com.breakman.cloud.utils;

import com.breakman.cloud.common.constant.AppConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class WebUtils {

    private static  final String SYSTEM_SOURCE  = "x-cos-meta-source";

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static HttpServletResponse getResponse(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
    }
    public static ServletContext getServletContext(){
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

    public static String getSystemSource(){
        String systemSource = "";
                Enumeration headerNames = getRequest().getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if(SYSTEM_SOURCE.equals(key)) {
                systemSource = getRequest().getHeader(key);
                break;
            }
        }
        if(StringUtils.isBlank(systemSource)){
            systemSource = (String) getRequest().getSession().getAttribute(AppConstants.SYSTEM_SOURCE_KEY);
        }
        return systemSource;
    }
}
