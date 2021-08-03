package com.devswpro.dao;

import com.devswpro.model.IntUserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountDAO extends JpaRepository<IntUserAccount, Long> {
    IntUserAccount findByUser_UsernameAndState(String userName, boolean state);
}
