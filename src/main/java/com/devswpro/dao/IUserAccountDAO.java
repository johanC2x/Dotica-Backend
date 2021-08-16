package com.devswpro.dao;

import com.devswpro.model.IntUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface IUserAccountDAO extends JpaRepository<IntUserAccount, Long> {
    IntUserAccount findByUser_UsernameAndState(String userName, boolean state);
    List<IntUserAccount> findByUser_Username(String userName);
    @Modifying
    @Query(value = "INSERT INTO int_user_account(created_date, state, id_account, id_usuario) " +
            "VALUES (:dateTransaction, 1, :idAccount, :idUser)", nativeQuery = true)
    @Transactional
    void saveAccount(@Param("dateTransaction")LocalDateTime dateTransaction, @Param("idAccount")Integer idAccount, @Param("idUser")Integer idUser);
}
