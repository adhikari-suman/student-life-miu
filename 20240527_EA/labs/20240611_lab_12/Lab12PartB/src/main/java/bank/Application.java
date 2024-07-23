package bank;

import bank.contract.*;
import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.CurrencyType;
import bank.domain.Customer;
import bank.service.AccountServiceImpl;
import bank.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


@SpringBootApplication
@EnableJms
@EnableKafka
@EnableScheduling
@EnableJpaRepositories(basePackages = "bank.repository")
public class Application implements CommandLineRunner {

    @Autowired
    AccountService accountService;

    private final String serverURL;

    @Autowired
    private RestTemplate restTemplate;

    public Application( @Value("http://localhost:${server.port}") String serverURL){
        this.serverURL = serverURL;

    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        // create 2 accounts;
//        accountService.createAccount(1263862, "Frank Brown");
//        accountService.createAccount(4253892, "John Doe");


        CreateAccountRequest createAccountRequest1 =
                new CreateAccountRequest(1263862L, "Frank Brown");
        CreateAccountRequest createAccountRequest2 =
                new CreateAccountRequest(4253892L, "John Doe");


        restTemplate.postForObject(serverURL+"/accounts",
                createAccountRequest1, AccountResponse.class);
        restTemplate.postForObject(serverURL+"/accounts",
                createAccountRequest2, AccountResponse.class);

        System.out.println("Server URL: "+serverURL);

        //use account 1;
//        accountService.deposit(1263862, 240);
//        accountService.deposit(1263862, 529);
//        accountService.withdrawEuros(1263862, 230);

        BalanceDepositRequest balanceDepositRequest1 =
                new BalanceDepositRequest(CurrencyType.USD, 240D);
        BalanceDepositRequest balanceDepositRequest2 =
                new BalanceDepositRequest(CurrencyType.USD, 529D);
        BalanceWithdrawRequest balanceWithdrawRequest1 =
                new BalanceWithdrawRequest(CurrencyType.EUR, 230D);

        restTemplate.postForEntity(serverURL+"/accounts/1263862/deposit",
                balanceDepositRequest1, AccountResponse.class);
        restTemplate.postForEntity(serverURL+"/accounts/1263862/deposit",
                balanceDepositRequest2, AccountResponse.class);
        restTemplate.postForEntity(serverURL+"/accounts/1263862/withdraw",
                balanceWithdrawRequest1, AccountResponse.class);






        //use account 2;
//        accountService.deposit(4253892, 12450);
//        accountService.depositEuros(4253892, 200);
//        accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");

        BalanceDepositRequest balanceDepositRequest4 =
                new BalanceDepositRequest(CurrencyType.USD, 12450D);
        BalanceDepositRequest balanceDepositRequest5 =
                new BalanceDepositRequest(CurrencyType.EUR, 200D);
        BalanceTransferRequest balanceTransferRequest6 =
                new BalanceTransferRequest(CurrencyType.USD, 100D, 1263862L,
                        "payment of invoice 10232");

        restTemplate.postForEntity(serverURL+"/accounts/4253892/deposit",
                balanceDepositRequest4, AccountResponse.class);
        restTemplate.postForEntity(serverURL+"/accounts/4253892/deposit",
                balanceDepositRequest5, AccountResponse.class);
        restTemplate.postForEntity(serverURL+"/accounts/4253892/transfer",
                balanceTransferRequest6, Void.class);




        // show balances
//        Collection<AccountResponse> accountlist = accountService.getAllAccounts();
//        CustomerResponse customer = null;
//        for (AccountResponse account : accountlist) {
//            customer = account.getCustomerResponse();
//            System.out.println("Statement for Account: " + account.getAccountNumber());
//            System.out.println("Account Holder: " + customer.getName());
//            System.out.println("-Date-------------------------"
//                    + "-Description------------------"
//                    + "-Amount-------------");
//            for (AccountEntryResponse entry : account.getEntryList()) {
//                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
//                        .toString(), entry.getDescription(), entry.getAmount());
//            }
//            System.out.println("----------------------------------------"
//                    + "----------------------------------------");
//            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
//                    account.getBalance());
//        }

        ResponseEntity<AccountsResponse> accountsResponse =
                restTemplate.getForEntity(
                        serverURL + "/accounts",
                        AccountsResponse.class
                );

        CustomerResponse customer = null;
        for (AccountResponse account : accountsResponse.getBody().getAccounts()) {
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


    }
}


