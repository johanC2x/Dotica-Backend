package com.devswpro.mapper;

import com.devswpro.dto.AccountDTO;
import com.devswpro.model.IntAccountType;

import java.util.Objects;

public class AccountMapper {

    public static AccountDTO map(IntAccountType entity){
        return AccountDTO.builder()
                .accountType(entity.getAccountType())
                .maxTransaction(entity.getMaxTransaction())
                .build();
    }

    public static AccountDTO map(IntAccountType entity, String userName){
        return AccountDTO.builder()
                .accountType(entity.getAccountType())
                .maxTransaction(entity.getMaxTransaction())
                .active(entity.getState().equals(0) ? Boolean.FALSE : Boolean.TRUE)
                .description(entity.getDescription())
                .amount(entity.getAmount())
                .currency(entity.getCurrency())
                .build();
    }

}
