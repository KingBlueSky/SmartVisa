package com.smart.visa.app.aop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.smart.visa.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author:      王江波
 * Date:        9:07 04/10/2018
 * Version:     1.0
 * Description: 方法入参和执行时间记录打印
 */
@Component
@Aspect
@EnableAspectJAutoProxy
@Slf4j
public class LogAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* com.smart.visa.app.controller..*(..))")
    public void controllerLog() {
    }

    /**
     * 正常环绕通知
     * @param joinPoint joinPoint
     * @return 正常的执行结果
     * @throws Throwable e
     */
    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        startTime.set(DateUtil.currentTime());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        String target = targetClass.getName() + "/" + method.getName();
        Object[] methodArgs = joinPoint.getArgs();
        String[] paramNames = signature.getParameterNames();
        String params = logParam(paramNames, methodArgs);

        log.info(target + "入参信息--> {}", params);
        Object result = joinPoint.proceed();

        log.info(target + "返回信息-->:{}", JSONObject.toJSONStringWithDateFormat(result, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS, SerializerFeature.WriteMapNullValue));
        log.info(target + "方法执行时间:--> {}ms", (DateUtil.currentTime() - startTime.get()));
        return result;

    }

    /**
     * 打印方法参数值  基本类型直接打印，非基本类型需要重写toString方法
     * @param paramsArgsName    方法参数名数组
     * @param paramsArgsValue   方法参数值数组
     */
    private String logParam(String[] paramsArgsName,Object[] paramsArgsValue){
        if (ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();
        buffer.append("{");
        for (int i = 0; i < paramsArgsName.length; i++) {
            //参数名
            String name = paramsArgsName[i];
            //参数值可能为空引发数组下标越界,不进行处理
            Object value = null;
            try {
                value = paramsArgsValue[i];
            } catch (Exception e) {
                log.error("参数名称：{}", paramsArgsName);
                log.error("参数值：{}", paramsArgsValue);
            }

            buffer.append(name).append(" = ");
            if (null != value) {
                if (isPrimite(value.getClass())) {
                    buffer.append(value).append(", ");
                } else {
                    buffer.append(value.toString()).append(", ");
                }
            } else {
                buffer.append("null, ");
            }
        }
        return buffer.append("}").toString();
    }

    /**
     * 判断是否为基本类型：包括String
     * @param clazz clazz
     * @return  true：是;     false：不是
     */
    private boolean isPrimite(Class<?> clazz){
        return clazz.isPrimitive() || clazz == String.class;
    }

    /**
     *
     * @Description 异常通知
     * @param point point
     * @param e e
     * @author LJN
     */
    @AfterThrowing(pointcut = "controllerLog()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {
        log.info("方法执行时间:--> {}ms", (DateUtil.currentTime() - startTime.get()));
        log.info(((MethodSignature)point.getSignature()).getMethod().getName() + "异常信息:--> {}", e.getMessage());
    }

}