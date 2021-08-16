package com.devswpro.dao;

import com.devswpro.model.IntAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IntAccountTypeDAO extends JpaRepository<IntAccountType, Integer> {
    IntAccountType findByAccountType(String accountType);

    @Transactional
    @Modifying
    @Query(value = "UPDATE int_user_account SET state = 0 where state = 1;", nativeQuery = true)
    void updateByStatus();
}
