package com.devswpro.service;

import com.devswpro.dto.AccessDTO;
import com.devswpro.model.IntAccess;

import java.util.List;

public interface IAccessService extends ICRUD<IntAccess> {
    List<AccessDTO> findByUser(String user);
    AccessDTO findByCreatedByAndToken(String user, String token);
    void sendMessage();
    boolean validateMaxTransaction(String user);
}
