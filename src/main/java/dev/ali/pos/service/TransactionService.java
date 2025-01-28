package dev.ali.pos.service;

import dev.ali.pos.entity.Order;
import dev.ali.pos.entity.Transaction;
import dev.ali.pos.repository.OrderRepository;
import dev.ali.pos.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }
    public Transaction update(Transaction transaction){
        return transactionRepository.save(transaction);
    }
    public Optional<Transaction> findById(Long id){
        return transactionRepository.findById(id);
    }
    public List<Transaction> findAllOrders(){
        return transactionRepository.findAll();
    }
}
