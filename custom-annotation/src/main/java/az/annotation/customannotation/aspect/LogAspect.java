package az.annotation.customannotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Around("@annotation(az.annotation.customannotation.annotation.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String name = (String) proceedingJoinPoint.getArgs()[0];

        Object[] allArgs = proceedingJoinPoint.getArgs();

       String target =  proceedingJoinPoint.getTarget().toString();

        log.info("===============");
        log.info("LOG: name: {} ", name);
        log.info("LOG: all args {}", allArgs);
        log.info("LOG: target {}", target);
        log.info("LOG: executed {}", proceedingJoinPoint.getSignature());

        return proceedingJoinPoint.proceed();

    }
}
