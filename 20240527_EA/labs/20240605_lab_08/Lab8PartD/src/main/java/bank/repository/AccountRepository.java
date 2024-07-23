package bank.repository;

import bank.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {

	public Account findAccountByAccountNumber(long accountNumber);


}
