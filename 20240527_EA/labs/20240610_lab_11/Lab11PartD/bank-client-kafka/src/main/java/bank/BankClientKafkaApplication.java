package bank;

import bank.contract.kafka.BalanceDepositRequest;
import bank.contract.kafka.BalanceWithdrawRequest;
import bank.domain.CurrencyType;
import bank.service.KafkaService;
import bank.contract.kafka.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BankClientKafkaApplication implements CommandLineRunner {

    @Autowired
    private KafkaService kafkaService;

    public static void main(String[] args) {
        SpringApplication.run(BankClientKafkaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Create account
        kafkaService.createAccount(new CreateAccountRequest(
                1245789L,
                "John Doe"
        ));

        Thread.sleep(1000);

        kafkaService.deposit(new BalanceDepositRequest(
                1245789L,
                CurrencyType.USD,
                200D
        ));

//        Thread.sleep(1000);

        kafkaService.deposit(new BalanceDepositRequest(
                1245789L,
                CurrencyType.EUR,
                200D
        ));

//        Thread.sleep(1000);

        kafkaService.withdraw(new BalanceWithdrawRequest(
                1245789L,
                CurrencyType.USD,
                100D
        ));

//        Thread.sleep(1000);

        kafkaService.withdraw(new BalanceWithdrawRequest(
                1245789L,
                CurrencyType.EUR,
                150D
        ));
    }
}
