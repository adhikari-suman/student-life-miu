package bank.service;


import bank.contract.kafka.BalanceDepositRequest;
import bank.contract.kafka.BalanceWithdrawRequest;
import bank.contract.kafka.CreateAccountRequest;

public interface KafkaService {
    public void createAccount(CreateAccountRequest createAccountRequest);
    public void withdraw(BalanceWithdrawRequest withdrawRequest);
    public void deposit(BalanceDepositRequest depositRequest);
}
