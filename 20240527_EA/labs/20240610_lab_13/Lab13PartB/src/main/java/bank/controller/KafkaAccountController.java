package bank.controller;

import bank.contract.kafka.BalanceDepositRequest;
import bank.contract.kafka.BalanceWithdrawRequest;
import bank.contract.kafka.CreateAccountRequest;
import bank.domain.Account;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaAccountController {

    @Autowired
    private AccountService accountService;

    @KafkaListener(topics = "create-account")
    public void createAccount(@Payload CreateAccountRequest createAccountRequest) {
       accountService.createAccount(createAccountRequest.getAccountNumber(),
               createAccountRequest.getCustomerName()
               );
    }

    @KafkaListener(topics = "withdraw")
    public void withdraw(@Payload BalanceWithdrawRequest withdrawRequest) {
        switch (withdrawRequest.getCurrencyType()) {
            case USD ->
                    accountService.withdraw(withdrawRequest.getAccountNumber(),
                            withdrawRequest.getWithdrawAmount());
            case EUR -> accountService.withdrawEuros(withdrawRequest.getAccountNumber(),
                    withdrawRequest.getWithdrawAmount());
        }
    }

    @KafkaListener(topics = "deposit")
    public void deposit(@Payload BalanceDepositRequest depositRequest) {
        switch (depositRequest.getCurrencyType()) {
            case USD ->
                    accountService.deposit(depositRequest.getAccountNumber(), depositRequest.getDepositAmount());
            case EUR -> accountService.depositEuros(depositRequest.getAccountNumber(),
                    depositRequest.getDepositAmount());
        }
    }
}
