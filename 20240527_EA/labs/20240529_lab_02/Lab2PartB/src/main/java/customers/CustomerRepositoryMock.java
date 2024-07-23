package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("customerRepository")
@Profile("test")
public class CustomerRepositoryMock implements CustomerRepository {


    private Logger logger;

    @Autowired
    public CustomerRepositoryMock(Logger logger) {
        this.logger = logger;
    }

    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test:: CustomerRepository: saving customer "+customer.getName());
        logger.log("Test:: Customer is saved in the DB: "+ customer.getName() );
    }
}
