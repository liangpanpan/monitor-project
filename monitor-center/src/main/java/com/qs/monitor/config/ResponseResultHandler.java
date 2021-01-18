package com.qs.monitor.config;

import com.alibaba.fastjson.JSON;
import com.qs.monitor.common.annotation.ResponseResult;
import com.qs.monitor.vo.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * @Describe
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/1/17       create this file
 * </pre>
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";

    /**
     * 是否请求包含了包装注解标记，没有就直接返回，不需要重写返回体
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class<?
            extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // 判断是否为ResultData 对象，如果是，则不进行任何处理
        if (body instanceof ResultData) {
            return body;
        }

        log.info("进入 返回体 重写格式 处理中。。。");

        // 最后需要返回String，简单方式在这里转换成String
        // 复杂方式再写一个StringMessageConverter，将
        // ResultData转换成String
        return JSON.toJSONString(ResultData.success(body));
        // return ResultData.success(body);
    }

    /**
     * 处理异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);

        ResultData errorResultData = new ResultData(201, "系统异常");
        errorResultData.setErrorMessage(e.getMessage());
        return errorResultData;
    }
}
