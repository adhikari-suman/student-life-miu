package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class LogAdvice {

    @After(value = "execution(* customers.EmailSender.sendEmail(..))  && args(email, message)")
    public void logSendMail(JoinPoint joinPoint, String email, String message) {

        EmailSender es = (EmailSender) joinPoint.getTarget();

        System.out.printf(
                "%s method=%s address=%s message= %s outgoing mail server = %s\n",
                LocalDateTime.now(),
                joinPoint.getSignature().getName(),
                email,
                message,
                es.getOutgoingMailServer()
        );

    }
}
