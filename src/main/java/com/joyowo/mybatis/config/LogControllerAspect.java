package com.joyowo.mybatis.config;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: chenby
 * Date: 2018-01-03
 */
@Aspect
@Component
public class LogControllerAspect { Logger logger = LoggerFactory.getLogger(LogControllerAspect.class);
    @AfterReturning(pointcut = "execution(* com.joyowo.mybatis.controller.*.*(..))", returning = "result")
    public void controllerLog(JoinPoint joinPoint,Object result) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer log = new StringBuffer();
        log.append("----------------- Path" + "==当前访问的路径" + "==>" + request.getRequestURI());
        log.append("----------------- parameters" + "==当前访问的路径request所带的所有参数" + "==>" + (new Gson().toJson(request.getParameterMap())));
        log.append("----------------- result" + "==返回结果" + "==>" + new Gson().toJson(result));
        String strBackUrl = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath()      //请求页面或其他地址
                + "?" + (request.getQueryString()); //参数
        log.append("----------------- backURL" + "==获取访问的完整路径" + "==>" + strBackUrl);
        logger.info(log.toString());
    }
}
