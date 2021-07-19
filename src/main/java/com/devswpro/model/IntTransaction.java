package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="int_transaction")
@Getter
@Setter
public class IntTransaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idTransaction;

    @Column(name="user", nullable = false)
    private String user;

    @Column(name="created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name="ip", nullable = true)
    private String ip;

    @Column(name="device", nullable = true)
    private String device;
}
