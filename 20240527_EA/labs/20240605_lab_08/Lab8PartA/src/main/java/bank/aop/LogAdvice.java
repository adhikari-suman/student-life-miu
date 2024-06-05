package bank.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAdvice {
    private final Logger logger;

    @Autowired
    public LogAdvice(Logger logger) {
        this.logger = logger;
    }

    @After("execution(* bank.repository.*.*(..))")
    public void log(JoinPoint joinPoint){
        logger.log(
                String.format("%s.%s(..) method called",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName()
                        )
        );
    }
}
