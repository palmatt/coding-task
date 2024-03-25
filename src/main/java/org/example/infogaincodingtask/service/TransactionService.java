package org.example.infogaincodingtask.service;

import org.example.infogaincodingtask.domain.PointsResponse;
import org.example.infogaincodingtask.domain.Transaction;
import org.example.infogaincodingtask.repository.TransactionRepository;
import org.example.infogaincodingtask.util.PointCalculatorUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return StreamSupport.stream(transactionRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Transaction getTransaction(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(long id) {
        transactionRepository.deleteById(id);
    }

    private List<Transaction> fetchThreeMonthsOldTransactionsGivenCustomerId(long customerId) {
        return transactionRepository.findAllByCustomer_idWithDateAfter(customerId,LocalDate.now().minusMonths(3));
    }

    public PointsResponse getCustomerPoints(Long id) {
        List<Transaction> transactions = fetchThreeMonthsOldTransactionsGivenCustomerId(id);
        int totalPoints = transactions.stream().map(PointCalculatorUtil::calculatePoints).reduce(0, Integer::sum);

        return new PointsResponse(totalPoints, transactions);
    }


}
