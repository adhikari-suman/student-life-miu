package bank.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JMSAdvice {
    private Logger logger;

    @Autowired
    public JMSAdvice(Logger logger) {
        this.logger = logger;
    }

    @After("execution(* bank.integration.jms.JMSSender.sendJMSMessage(String)) && args(message)")
    public void logMessage(String message) {
        logger.log("JMSSender: sending JMS message =" + message);

    }
}
