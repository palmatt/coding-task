package org.example.infogaincodingtask.controller;

import org.example.infogaincodingtask.domain.Transaction;
import org.example.infogaincodingtask.service.TransactionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.getTransaction(id);
    }

    @PostMapping()
    public String saveTransaction(@RequestBody Transaction transaction) {
        return "ok";
    }

    @PutMapping()
    public String updateTransaction(@RequestBody Transaction transaction) {
        return "ok";
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        return "ok";
    }
}
