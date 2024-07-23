package bank.events;

import bank.domain.CurrencyType;
import bank.domain.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {
    private LocalDateTime timestamp;

    private Long accountNumber;

    private Double amount;

    private TransactionType transactionType;

    private Long receiverAccountNumber;

    private String message;
}
