package bank.integration.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("jmsSender")
public class JMSSenderImpl implements JMSSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendJMSMessage(String text) {

        jmsTemplate.convertAndSend("tax-reporting", text);

    }

}
