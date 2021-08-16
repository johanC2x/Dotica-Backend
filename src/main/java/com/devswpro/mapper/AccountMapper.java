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
                .active(entity.getAccounts().stream()
                        .filter(x -> Objects.nonNull(x.getUser()))
                        .filter(x -> x.isState())
                        .filter(x -> x.getUser().getUsername().equals(userName))
                        .count() == 1)
                .description(entity.getDescription())
                .amount(entity.getAmount())
                .currency(entity.getCurrency())
                .build();
    }

}
