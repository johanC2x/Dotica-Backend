package com.devswpro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TransactionDTO {
    private Long totalTransaction;
    private List<AccountDTO> accounts;
}
