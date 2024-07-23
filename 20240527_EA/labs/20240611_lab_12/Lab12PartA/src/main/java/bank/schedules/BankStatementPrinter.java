package bank.schedules;

import bank.contract.AccountEntryResponse;
import bank.contract.AccountResponse;
import bank.contract.CustomerResponse;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BankStatementPrinter {

    @Autowired
    private AccountService accountService;

    @Scheduled(fixedRate = 20000)
    public void printAllBankStatements() {
        System.out.printf("\n\n--------------------- START:: BANK STATEMENT PRINTER [%s] ---------------------", LocalDateTime.now());

        CustomerResponse customer = null;

        for (AccountResponse account : accountService.getAllAccounts()) {
            customer = account.getCustomerResponse();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            for (AccountEntryResponse entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                        .toString(), entry.getDescription(), entry.getAmount());
            }
            System.out.println("----------------------------------------"
                    + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                    account.getBalance());
        }

        System.out.printf("\n\n--------------------- END:: BANK STATEMENT PRINTER [%s] ---------------------", LocalDateTime.now());

    }

}
