package az.annotation.customannotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackExecutionTimeAspect {

    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

//    @Before("@annotation(TrackExecutionTime)")
//    public void beforeMethodExecutionTime(JoinPoint joinPoint) {
//        System.out.println(" Starting execution of method " + joinPoint.getSignature());
//        long startTime = System.currentTimeMillis();
//        System.out.println(" start time: " + startTime);
//    }
//
//    public void afterMethodExecution(JoinPoint joinPoint) {
//        long endTime = System.currentTimeMillis();
//        long executionTime = endTime - s
//    }

    @Before("@annotation(az.annotation.customannotation.annotation.TrackExecutionTime)")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Starting execution of method: " + joinPoint.getSignature());
        long startTime = System.currentTimeMillis();
        startTimeThreadLocal.set(startTime);
    }

    @AfterReturning(value = "@annotation(az.annotation.customannotation.annotation.TrackExecutionTime)", returning = "result")
    public void afterMethodExecution(JoinPoint joinPoint, Object result) {
        long endTime = System.currentTimeMillis();
        long startTime = startTimeThreadLocal.get();
        long executionTime = endTime - startTime;
        System.out.println("Method execution completed in " + executionTime + " milliseconds. Result: " + result);
    }
}
