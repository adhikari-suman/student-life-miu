package accounts.service;

import accounts.domain.Account;
import accounts.repository.AccountRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class AccountServiceTests {


    @TestConfiguration
    static class AccountServiceTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountService();
        }
    }

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        Account account = new Account("123456", 1000D, "Ariel");
        Account newAccount = new Account("123457", 1000D, "Payman");

        Mockito.when(accountRepository.findById(account.getAccountNumber())).thenReturn(
                Optional.of(account));
        Mockito.when(accountRepository.findById("123458")).thenReturn(Optional.empty());

        Mockito.when(accountRepository.save(newAccount)).thenReturn(newAccount);
        Mockito.when(accountRepository.findById(newAccount.getAccountNumber())).thenReturn(

                Optional.of(newAccount));


//        Mockito.when(accountRepository.save(newAccount)).thenThrow(new RuntimeException());
    }

    @Test
    void getAccount_shouldReturnAccount() {
        // Arrange

        // Act
        AccountResponse account = accountService.getAccount("123456");

        // Assert
        assertThat(account).isNotNull();
        assertThat(account.getAccountNumber()).isEqualTo("123456");

    }

    @Test
    void getAccount_shouldReturnNull() {
        // Arrange

        // Act
        AccountResponse account = accountService.getAccount("123458");

        // Assert
        assertThat(account).isNull();
    }

    @Test
    void createAccount_shouldSaveAccount() {
        // Arrange
        Account newAccount = new Account("123457", 1000D, "Payman");

        // Act
        accountService.createAccount(newAccount.getAccountNumber(), newAccount.getBalance(), newAccount.getAccountHolder());
        AccountResponse accountFound = accountService.getAccount(newAccount.getAccountNumber());


        // Assert
        assertThat(accountFound).isNotNull();
        assertThat(accountFound.getAccountNumber()).isEqualTo(newAccount.getAccountNumber());
    }
//
//    @Test
//    void createAccount_shouldNotSaveAccount() {
//        // Arrange
//        Account existingAccount = new Account("123457", 1000D, "Payman");
//
//        // Act
//        RuntimeException exception = null;
//        try {
//            accountService.createAccount(existingAccount.getAccountNumber(),
//                    existingAccount.getBalance(),
//                    existingAccount.getAccountHolder());
//        } catch (RuntimeException e) {
//            exception = e;
//        }
//
//        // Assert
////        assertThat(exception).isNotNull();
//
//    }


}
