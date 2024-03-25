package org.example.infogaincodingtask.repository;

import org.example.infogaincodingtask.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Override
    Optional<Transaction> findById(Long aLong);

    List<Transaction> findAllByCustomer_CustomerId(Long customerId);

    @Query("select transaction from Transaction transaction where transaction.transactionDate >= :afterDate and transaction.customer.customerId = :customerId")
    List<Transaction> findAllByCustomer_idWithDateAfter(long customerId,LocalDate afterDate);
}
