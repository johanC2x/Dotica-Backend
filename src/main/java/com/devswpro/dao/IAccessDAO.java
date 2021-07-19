package com.devswpro.dao;

import com.devswpro.model.IntAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccessDAO extends JpaRepository<IntAccess, Long> {
    List<IntAccess> findByCreatedBy(String user);
    IntAccess findByCreatedByAndToken(String createdBy, String token);
}
