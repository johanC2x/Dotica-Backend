package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="int_access")
@Getter
@Setter
public class IntAccess {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idAccess;

    @Column(name="APP_NAME", nullable = false)
    private String appName;

    @Column(name="TOKEN", nullable = false)
    private String token;

    @Column(name="WEB_SITE", nullable = false)
    private String webSite;

    @Column(name="DESCRIPTION", nullable = true)
    private String description;

    @Column(name="CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name="CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    @Column(name="STATE", nullable = false)
    private boolean state;

}