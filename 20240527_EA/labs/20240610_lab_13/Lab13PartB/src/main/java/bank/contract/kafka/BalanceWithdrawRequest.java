package bank.contract.kafka;

import bank.domain.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceWithdrawRequest {
    private Long accountNumber;
    private CurrencyType currencyType;
    private Double withdrawAmount;
}
