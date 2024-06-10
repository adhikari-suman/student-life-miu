package bank.contract;

import bank.domain.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceDepositRequest {
    private CurrencyType currencyType;
    private Double depositAmount;
}
