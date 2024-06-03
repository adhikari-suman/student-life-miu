package bank.service;

import bank.contract.AccountResponse;
import bank.domain.Account;

import java.util.Collection;

public interface AccountService {

    public AccountResponse createAccount(long accountNumber, String customerName);

    public AccountResponse getAccount(long accountNumber);

    public Collection<AccountResponse> getAllAccounts();

    public void deposit (long accountNumber, double amount);

    public void withdraw (long accountNumber, double amount);

    public void depositEuros (long accountNumber, double amount);

    public void withdrawEuros (long accountNumber, double amount);

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);

}
