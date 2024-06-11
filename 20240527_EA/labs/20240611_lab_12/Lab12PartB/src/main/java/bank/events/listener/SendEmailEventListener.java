package bank.events.listener;

import bank.events.SendEmailEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class SendEmailEventListener {

    @EventListener
    @Async
    public void listenSendEmailEvent(SendEmailEvent sendEmailEvent) {
        System.out.println("[SendEmailEventListener] SENDING EMAIL:: "+sendEmailEvent.getMessage());
    }
}
