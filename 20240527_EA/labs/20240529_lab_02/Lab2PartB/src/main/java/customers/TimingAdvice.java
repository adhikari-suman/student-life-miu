package customers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TimingAdvice {

    @Around("execution(* customers.*Repository.*(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();

        // print the time to the console
        System.out.printf("Call to \"%s.%s(..)\" took %d ms\n",
                call.getTarget().getClass().getName(),
                call.getSignature().getName(),
                totaltime
                );

        return retVal;
    }
}
