package com.ibrahim.bank_application.repository;

import com.ibrahim.bank_application.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
