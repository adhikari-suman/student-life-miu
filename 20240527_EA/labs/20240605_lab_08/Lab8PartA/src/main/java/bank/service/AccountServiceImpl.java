package bank.service;

import bank.contract.AccountResponse;
import bank.domain.Account;
import bank.domain.Customer;
import bank.integration.jms.JMSSender;
import bank.integration.jms.JMSSenderImpl;
import bank.integration.logging.Logger;
import bank.integration.logging.LoggerImpl;
import bank.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Collection;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private CurrencyConverter currencyConverter;
    private JMSSender jmsSender;
    private Logger logger;

    private ModelMapper modelMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CurrencyConverter currencyConverter, JMSSender jmsSender, Logger logger, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.currencyConverter = currencyConverter;
        this.jmsSender = jmsSender;
        this.logger = logger;
        this.modelMapper = modelMapper;
    }

    public AccountResponse createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountRepository.save(account);
        logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        return modelMapper.map(account, AccountResponse.class);
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber);
        account.deposit(amount);
        accountRepository.save(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
        }
    }


    public AccountResponse getAccount(long accountNumber) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber);
        return modelMapper.map(account, AccountResponse.class);
    }

    public Collection<AccountResponse> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(account -> modelMapper.map(account, AccountResponse.class))
                .toList();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber);
        account.withdraw(amount);
        accountRepository.save(account);
        logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }

    public void depositEuros(long accountNumber, double amount) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountRepository.save(account);
        logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        if (amountDollars > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
        }
    }

    public void withdrawEuros(long accountNumber, double amount) {
        Account account = accountRepository.findAccountByAccountNumber(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountRepository.save(account);
        logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
    }


    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountRepository.findAccountByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findAccountByAccountNumber(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= " + fromAccount + " to account with accountNumber= " + toAccount);
        }
    }

}
