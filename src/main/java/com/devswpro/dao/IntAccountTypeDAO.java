package com.devswpro.dao;

import com.devswpro.model.IntAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IntAccountTypeDAO extends JpaRepository<IntAccountType, Integer> {
    IntAccountType findByAccountType(String accountType);

    @Transactional
    @Modifying
    @Query(value = "UPDATE int_user_account SET state = 0 where state = 1;", nativeQuery = true)
    void updateByStatus();

    @Query(value = "SELECT " +
            "T.id,T.account_key,T.account_type,T.max_transaction,T.description,T.amount,T.currency, " +
            "(SELECT COUNT(*) FROM int_user_account ac, usuario u where ac.id_usuario = u.id_usuario and u.id_usuario = T.id AND u.nombre_completo = :userName AND ac.state = 1) AS state " +
            "FROM int_account_type T", nativeQuery = true)
    List<IntAccountType> getAll(@Param("userName")String userName);
}
