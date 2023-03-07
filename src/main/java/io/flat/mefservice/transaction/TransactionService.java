package io.flat.mefservice.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean createTransaction(TransactionDto transactionDto){
        Transaction transaction = new Transaction();

        transaction.setName(transactionDto.name);
        transaction.setDescription(transactionDto.description);
        transaction.setMinistryUUid(transactionDto.ministryUUID);

        transactionRepository.save(transaction);

        return transaction.getId() != null;
    }

    public Transaction getTransactionById(Long id){
        return transactionRepository.findById(id).orElseGet(null);
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
}
