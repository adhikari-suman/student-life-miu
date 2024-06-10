package bank.repository;

import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account findAccountByAccountNumber(long accountNumber);


}
