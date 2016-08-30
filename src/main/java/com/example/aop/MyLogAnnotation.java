package com.example.aop;

import com.example.utils.LogAop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by Macro_Li on 2016/3/19.
 */
@Aspect
@Component
public class MyLogAnnotation {
    @Pointcut("execution(* com.example..*(..))")
    private void pointcut() {
    }

    @Around("pointcut()&& @annotation(com.example.utils.LogAop)")
    public Object logAopMethod(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        LogAop logDuration = signature.getMethod().getAnnotation(LogAop.class);
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return pjp.proceed();
        } catch (Exception e) {
            System.out.println("exception"+e);
            throw new Exception("erfer");
        }finally {
            stopWatch.stop();
            System.out.println(logDuration.name());
        }
    }
}
