package com.devswpro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class AccountDTO {

    private String accountType;
    private Integer maxTransaction;
    private boolean active;
    private String description;
    private String currency;
    private BigDecimal amount;
}
