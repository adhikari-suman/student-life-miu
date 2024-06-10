package edu.miu.taxservice.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxService {

    @JmsListener(destination = "tax-reporting")
    public void receive(String message){
        System.out.println(message);
    }
}
