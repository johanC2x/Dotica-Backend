package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="int_account_type")
@Getter
@Setter
public class IntAccountType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="ACCOUNT_TYPE", nullable = false)
    private String accountType;
    @Column(name="MAX_TRANSACTION", nullable = false)
    private Integer maxTransaction;
    @Column(name="ACCOUNT_KEY", nullable = false)
    private String accountKey;
    @Column(name="DESCRIPTION", nullable = false)
    private String description;
    @Column(name="AMOUNT", nullable = false)
    private BigDecimal amount;
    @Column(name="CURRENCY", nullable = false)
    private String currency;
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "account"
    )
    private List<IntUserAccount> accounts;

    @Column(name="STATE", nullable = false)
    private Integer state;
}
