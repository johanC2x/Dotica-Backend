package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="int_user_account")
@Getter
@Setter
public class IntUserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="created_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name="state", nullable = false)
    private boolean state;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, insertable = false, updatable = false)
    private Usuario user;
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false, insertable = false, updatable = false)
    private IntAccountType account;
}
