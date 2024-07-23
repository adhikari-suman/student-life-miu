package bank.events.listener;


import bank.domain.TraceRecord;
import bank.events.TransactionEvent;
import bank.service.TraceRecordService;
import bank.service.TraceRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class TransactionEventListener {

    @Autowired
    private TraceRecordServiceImpl traceRecordService;


    @Async
    @EventListener
    public void handleTransactionEvent(TransactionEvent transactionEvent) {
        System.out.println("TransactionEventListener: "+ transactionEvent.getMessage());

        switch (transactionEvent.getTransactionType()) {
            case DEPOSIT:
            case WITHDRAW:
                TraceRecord traceRecord = new TraceRecord(
                        null, transactionEvent.getTimestamp(),
                        transactionEvent.getAccountNumber(),
                        transactionEvent.getTransactionType().name(),
                        transactionEvent.getAmount()
                );

                traceRecordService.add(traceRecord);

                break;

            case TRANSFER:
                TraceRecord traceRecord2 = new TraceRecord(
                        null, transactionEvent.getTimestamp(),
                        transactionEvent.getAccountNumber(),
                        transactionEvent.getTransactionType().name(),
                        -transactionEvent.getAmount()
                );

                traceRecordService.add(traceRecord2);

                TraceRecord traceRecord3 = new TraceRecord(
                        null, transactionEvent.getTimestamp(),
                        transactionEvent.getReceiverAccountNumber(),
                        transactionEvent.getTransactionType().name(),
                        transactionEvent.getAmount()
                );

                traceRecordService.add(traceRecord3);
                break;

            case null, default:
                break;
        }


    }
}
