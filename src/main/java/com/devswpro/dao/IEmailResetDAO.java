package com.devswpro.dao;

import com.devswpro.model.EmailReset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailResetDAO extends JpaRepository<EmailReset, Integer> {
    EmailReset findByActiveAndToken(Boolean active, String token);
}
