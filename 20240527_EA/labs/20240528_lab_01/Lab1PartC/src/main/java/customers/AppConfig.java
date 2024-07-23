package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

   @Bean
    public Logger logger() {
        return new LoggerImpl();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl(
                logger()
        );
    }

    @Bean
    public CustomerService customerService(){
       CustomerServiceImpl cs = new CustomerServiceImpl();

       cs.setCustomerRepository(customerRepository());
       cs.setEmailSender(emailSender());

       return cs;
    }

    @Bean
    public EmailSender emailSender(){
        return new EmailSenderImpl(
                logger()
        );
    }
}
