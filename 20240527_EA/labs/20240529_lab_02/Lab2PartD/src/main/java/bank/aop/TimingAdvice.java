package bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TimingAdvice {



    @Around("execution(* bank.service.*.*(..))")
    public Object timeMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(joinPoint.getSignature().getName());
        Object retVal = joinPoint.proceed();
        sw.stop();

        long totalTime = sw.getLastTaskTimeMillis();
        System.out.printf("\nCall to %s.%s(..) took %d ms\n\n",
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName(),
                totalTime
                );

        return retVal;
    }
}
