package com.sky.aop;

import com.sky.annotation.AutoFill;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class commAop {

    @Pointcut("@annotation(com.sky.annotation.AutoFill)")
    void pt(){};

    @Before("pt()")
    void before(JoinPoint joinPoint){
        log.info("AOP");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AutoFill autoFill = method.getAnnotation(AutoFill.class);
        Object[] args = joinPoint.getArgs();
        if (autoFill.value() == OperationType.INSERT){
            try {
                Method setCreateTime = args[0].getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);
                Method setCreateUser = args[0].getClass().getDeclaredMethod("setCreateUser", Long.class);
                Method setUpdateTime = args[0].getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = args[0].getClass().getDeclaredMethod("setUpdateUser", Long.class);
                setCreateTime.invoke(args[0], LocalDateTime.now());
                setCreateUser.invoke(args[0], BaseContext.getCurrentId());
                setUpdateTime.invoke(args[0], LocalDateTime.now());
                setUpdateUser.invoke(args[0], BaseContext.getCurrentId());

            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                Method setUpdateTime = args[0].getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                Method setUpdateUser = args[0].getClass().getDeclaredMethod("setUpdateUser", Long.class);
                setUpdateTime.invoke(args[0], LocalDateTime.now());
                setUpdateUser.invoke(args[0], BaseContext.getCurrentId());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
