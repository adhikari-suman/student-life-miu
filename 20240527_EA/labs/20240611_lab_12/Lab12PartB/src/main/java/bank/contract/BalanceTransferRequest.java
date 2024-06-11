package bank.contract;

import bank.domain.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceTransferRequest {
    private CurrencyType currencyType = CurrencyType.USD;
    private Double transferAmount;
    private Long receiverAccount;
    private String description;
}
