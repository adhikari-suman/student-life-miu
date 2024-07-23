package bank.service;

import bank.contract.kafka.BalanceDepositRequest;
import bank.contract.kafka.BalanceWithdrawRequest;
import bank.contract.kafka.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<String, CreateAccountRequest> createAccountTemplate;
    @Autowired
    private KafkaTemplate<String, BalanceWithdrawRequest> withdrawTemplate;
    @Autowired
    private KafkaTemplate<String, BalanceDepositRequest> depositTemplate;

    @Override
    public void createAccount(CreateAccountRequest createAccountRequest) {
        createAccountTemplate.send("create-account", createAccountRequest);
    }

    @Override
    public void withdraw(BalanceWithdrawRequest withdrawRequest) {
        withdrawTemplate.send("withdraw", withdrawRequest);
    }

    @Override
    public void deposit(BalanceDepositRequest depositRequest) {
        depositTemplate.send("deposit", depositRequest);
    }
}
