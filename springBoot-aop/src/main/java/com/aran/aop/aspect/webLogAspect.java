package com.aran.aop.aspect;

import com.aran.aop.annotation.WebLogger;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 以自定义的 @WebLogger为切点
 * @Author Aran
 * @Date 2020/7/14 7:47 上午
 */

@Slf4j
@Component
@Aspect
public class webLogAspect {

 /**
  * 换行符
  */
 private static final String LINE_SEPARATOR = System.lineSeparator();
 @Pointcut("@annotation(com.aran.aop.annotation.WebLogger)")
 public void webLog(){}

 @Around("webLog()")
 public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
  long startTime = System.currentTimeMillis();
  Object result = proceedingJoinPoint.proceed();
  //打印出参
  log.info("Response Args：{}",new Gson().toJson(result));
  //执行耗时
  log.info("Time-Consuming：{} ms",System.currentTimeMillis()- startTime);
return result;
 }

@Before("webLog()")
 public void doBefore(JoinPoint joinPoint) throws Exception {
  //开始打印请求日志
  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
  HttpServletRequest request = attributes.getRequest();

  //获取 @webLog 注解的描述信息
  String methodDescription = getAspectLogDescription(joinPoint);

  //打印请求相关参数
  log.info("====================start====================");
  //打印请求Url
  log.info("URL          : {}",request.getRequestURL().toString());
  log.info("Description  : {}",methodDescription);
  log.info("HTTP Method  : {}", request.getMethod());
  log.info("Class Method : {}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
  log.info("IP           : {}",request.getRemoteAddr());
  log.info("Request Args : {}",new Gson().toJson(joinPoint.getArgs()));
 }

 @After("webLog()")
 public void doAfter(){
  log.info("====================End====================" + LINE_SEPARATOR);
 }

 /**
  * 获取切面注解的描述
  *
  * @param joinPoint 切点
  * @return 描述信息
  * @throws Exception
  */
 public String getAspectLogDescription(JoinPoint joinPoint)
         throws Exception {
  String targetName = joinPoint.getTarget().getClass().getName();
  String methodName = joinPoint.getSignature().getName();
  Object[] arguments = joinPoint.getArgs();
  Class targetClass = Class.forName(targetName);
  Method[] methods = targetClass.getMethods();
  StringBuilder description = new StringBuilder("");
  for (Method method : methods) {
   if (method.getName().equals(methodName)) {
    Class[] clazzs = method.getParameterTypes();
    if (clazzs.length == arguments.length) {
     description.append(method.getAnnotation(WebLogger.class).description());
     break;
    }
   }
  }
  return description.toString();
 }
}
