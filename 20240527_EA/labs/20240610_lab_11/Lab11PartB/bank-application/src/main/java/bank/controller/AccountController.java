package bank.controller;

import bank.contract.*;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    public AccountService accountService;

    @GetMapping
    public ResponseEntity<AccountsResponse> getAllAccounts() {
        AccountsResponse accountsResponse =
                new AccountsResponse(accountService.getAllAccounts())
                ;

        return ResponseEntity.ok(accountsResponse);
    }


    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {

        var accountResponse =
                accountService.createAccount(createAccountRequest.getAccountNumber(),
                        createAccountRequest.getCustomerName()
                );


        return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }


    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<AccountResponse> depositAmount(@PathVariable(
            "accountNumber") Long accountNumber,
                                           @RequestBody BalanceDepositRequest balanceDepositRequest) {

        switch (balanceDepositRequest.getCurrencyType()) {
            case USD ->
                    accountService.deposit(accountNumber, balanceDepositRequest.getDepositAmount());
            case EUR -> accountService.depositEuros(accountNumber,
                    balanceDepositRequest.getDepositAmount());
        }

        var account = accountService.getAccount(accountNumber);

        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<?> withdrawAmount(@PathVariable(
            "accountNumber") Long accountNumber,
                                           @RequestBody BalanceWithdrawRequest balanceWithdrawRequest) {

        switch (balanceWithdrawRequest.getCurrencyType()) {
            case USD ->
                    accountService.withdraw(accountNumber,
                            balanceWithdrawRequest.getWithdrawAmount());
            case EUR -> accountService.withdrawEuros(accountNumber,
                    balanceWithdrawRequest.getWithdrawAmount());
        }

        var account = accountService.getAccount(accountNumber);

        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{accountNumber}/transfer")
    public ResponseEntity<?> withdrawAmount(@PathVariable(
            "accountNumber") Long accountNumber,
                                            @RequestBody BalanceTransferRequest balanceTransferRequest) {

       return switch (balanceTransferRequest.getCurrencyType()) {
            case USD -> {
                accountService.transferFunds(accountNumber,
                        balanceTransferRequest.getReceiverAccount(),
                        balanceTransferRequest.getTransferAmount(),
                        balanceTransferRequest.getDescription()
                );

               yield new ResponseEntity<>(HttpStatus.ACCEPTED);
            }

            case EUR -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
           case null, default -> new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        };

    }


}
