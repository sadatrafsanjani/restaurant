package com.restaurant.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Aspect
@Component
public class ServiceLoggerAspect {

    private final ObjectMapper objectMapper;

    @Before("within(com.restaurant.service..*)")
    public void endpointBefore(JoinPoint joinPoint) {

        Map<String, Object> parameters = getParameters(joinPoint);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {

            if(!joinPoint.getTarget().getClass().getSimpleName().equals("DDApprovedTrxSummaryService") && !joinPoint.getSignature().getName().equals("getAllApprovedTransaction")){
                log.info("[SERVICE]: {}, [METHOD]: {}, ",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName());
            }

            if(!parameters.isEmpty()){
                log.info("Payload: {}", objectMapper.writeValueAsString(parameters));
            }

        } catch (JsonProcessingException e) {
            log.error("{}", e.getMessage());
        }
    }

    @AfterReturning(value = ("within(com.restaurant.service..*)"), returning = "returnValue")
    public void endpointAfterReturning(JoinPoint joinPoint, Object returnValue) {

        //objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {

            if(returnValue != null){
                log.info("[SERVICE RESPONSE]: {}", objectMapper.writeValueAsString(returnValue));
            }
        } catch (JsonProcessingException e) {
            log.error("{}", e.getMessage());
        }
    }

    @AfterThrowing(pointcut = ("within(com.restaurant.controller..*)"), throwing = "e")
    public void endpointAfterThrowing(JoinPoint p, Exception e) {

        log.error(e.getMessage());
        e.printStackTrace();
        log.error(p.getTarget().getClass().getSimpleName() + " " + p.getSignature().getName() + " " + e.getMessage());
    }

    private Map<String, Object> getParameters(JoinPoint joinPoint) {

        CodeSignature signature = (CodeSignature) joinPoint.getSignature();

        HashMap<String, Object> map = new HashMap<>();
        String[] parameterNames = signature.getParameterNames();

        for (int i = 0; i < parameterNames.length; i++) {
            map.put(parameterNames[i], joinPoint.getArgs()[i]);
        }

        return map;
    }
}
