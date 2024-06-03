package bank.config;

import bank.contract.AccountResponse;
import bank.contract.CustomerResponse;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
