package com.devswpro.dao;

import com.devswpro.model.IntTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionDAO extends JpaRepository<IntTransaction, Long> {
    Long countByUser(String user);
}
