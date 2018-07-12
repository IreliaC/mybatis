package com.joyowo.mybatis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Author: chenby
 * Date: 2018-05-21
 */
@Slf4j
public class RestClient {

    @Autowired
    AsyncRestTemplate asyncRestTemplate;

    public void postByAsynWithRequest(String url, Map<String, Object> param) {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            postParameters.add(entry.getKey(), entry.getValue());
        }
        log.debug("asyn参数" + RequestContextHolder.getRequestAttributes());
        if(RequestContextHolder.getRequestAttributes() != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Map<String, String[]> map1 = request.getParameterMap();
            for (Map.Entry<String, String[]> entry : map1.entrySet()) {
                postParameters.add(entry.getKey(), entry.getValue()[0]);
            }
            log.debug("asyn参数" + postParameters);
        }
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(postParameters, headers);
        try {
            asyncRestTemplate.exchange(url, HttpMethod.POST,requestEntity,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
