package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="int_account_type")
@Getter
@Setter
public class AccountType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idAccountType;

    @Column(name="ACCOUNT_TYPE", nullable = false)
    private String accountType;

    @Column(name="MAX_TRANSACTION", nullable = false)
    private Integer maxTransaction;

    @Column(name="ACCOUNT_KEY", nullable = false)
    private String accountKey;
}
