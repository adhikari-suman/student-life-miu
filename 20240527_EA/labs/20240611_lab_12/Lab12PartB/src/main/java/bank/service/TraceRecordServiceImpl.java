package bank.service;

import bank.domain.TraceRecord;
import bank.repository.TraceRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("traceRecordService")
public class TraceRecordServiceImpl implements TraceRecordService {

    @Autowired
    private TraceRecordRepository traceRecordRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(TraceRecord record) {
        traceRecordRepository.save(record);
    }
}
