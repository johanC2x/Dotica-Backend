package com.devswpro.service;

import com.devswpro.dto.TransactionDTO;

public interface AccountService {
    TransactionDTO getAll() throws Exception;
}