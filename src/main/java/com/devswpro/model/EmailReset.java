package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="email_reset")
@Getter
@Setter
public class EmailReset {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEmailReset;

    @Column(name="token", nullable=false)
    private String token;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="active", nullable=false)
    private boolean active;

    @Column(name="created_date", nullable = false)
    private LocalDateTime createdDate;
}
