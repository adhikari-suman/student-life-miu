package accounts.repository;

import accounts.domain.Account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
 class AccountRepositoryTests {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByAccountHolder_shouldReturnAccount() {
        // Arrange
        Account account = new Account("123456", 1000D, "Ariel Adhikari");
        testEntityManager.persist(account);
        testEntityManager.flush();

        // Act
        Account found = accountRepository.findByAccountHolder(account.getAccountHolder());

        // Assert
       assertThat(found.getAccountHolder()).isEqualTo(account.getAccountHolder());
    }

    @Test
    void findByAccountHolder_shouldReturnEmptyList() {
        // Arrange

        // Act
        Account found = accountRepository.findByAccountHolder("123456");

        // Assert
        assertThat(found).isNull();
    }


    @Test
    void findAccountsByBalanceGreaterThan_shouldReturnAccounts() {
        // Arrange
        Account account = new Account("123456", 10000D, "Ariel Adhikari");
        testEntityManager.persist(account);
        testEntityManager.flush();

        // Act
        List<Account> accounts = accountRepository.findAccountsByBalanceGreaterThan(1000D);

        // Assert
        assertThat(accounts.getFirst().getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
    void findAccountsByBalanceGreaterThan_shouldReturnNoAccounts() {
        // Arrange
        Account account = new Account("123456", 100D, "Ariel Adhikari");
        testEntityManager.persist(account);
        testEntityManager.flush();

        // Act
        List<Account> accounts = accountRepository.findAccountsByBalanceGreaterThan(1000D);

        // Assert
        assertThat(accounts).isNullOrEmpty();
    }

    @Test
     void findByAccountNumber_shouldReturnAccount() {
        // Arrange
        Account account = new Account("123456", 1000D, "Ariel Adhikari");
        testEntityManager.persist(account);
        testEntityManager.flush();

        // Act
        Account found = accountRepository.findByAccountNumber(account.getAccountNumber());

        // Assert
        assertThat(found.getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
     void findByAccountNumber_shouldReturnEmptyList() {
        // Arrange

        // Act
        Account found = accountRepository.findByAccountNumber("123456");

        // Assert
        assertThat(found).isNull();
    }



}
