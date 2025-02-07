package com.ibrahim.bank_application.service;

import com.ibrahim.bank_application.dto.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    void saveTransaction(TransactionDto transactiondto);
}
