package bank.service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.TraceRecord;
import bank.integration.EmailSender;
import bank.repository.AccountRepository;
import bank.repository.CustomerRepository;
import bank.repository.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BankService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private TraceRecordService recordService;
	

	@Transactional
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String AccountNumber){
		String message;
		TraceRecord traceRecord = new TraceRecord();
		try {
			Account account = new Account(AccountNumber);
			accountRepository.save(account);
			Customer customer = new Customer(customerId, customerName);
			customer.setAccount(account);
			customerRepository.saveCustomer(customer);

			message = String.format("Welcome %s", customerName);
			emailSender.sendEmail(emailAddress, message);

			traceRecord.setTimestamp(LocalDateTime.now());
			traceRecord.setText(String.format("Customer %s created with account %s",
					customerName, AccountNumber
					));

		} catch (Exception e){
			message = String.format("We could not create your account %s", AccountNumber);
			emailSender.sendEmail(emailAddress, message);

			traceRecord.setTimestamp(LocalDateTime.now());
			traceRecord.setText(String.format("Could not create customer %s with account %s",
					customerName, AccountNumber
			));

			throw e;
		} finally {
			recordService.saveTraceRecord(traceRecord);
		}
	}

}
