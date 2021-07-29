package com.devswpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="int_company", uniqueConstraints={@UniqueConstraint(columnNames = {"ruc"})})
@Getter
@Setter
public class IntCompany {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", nullable = false)
    private Integer idCompany;

    @Column(name="RUC", nullable = false)
    private String ruc;

    @Column(name="RAZON_SOCIAL", nullable = false)
    private String name;

    @Column(name="TAXPAYER_STATUS", nullable = false)
    private String taxpayerStatus;

    @Column(name="RESIDENCE_CONDITION", nullable = false)
    private String residenceCondition;

    @Column(name="LOCATION", nullable = false)
    private String location;

    @Column(name="ROAD_TYPE")
    private String roadType;

    @Column(name="STREET_NAME")
    private String streetName;

    @Column(name="ZONE_CODE")
    private String zoneCode;

    @Column(name="ZONE_TYPE")
    private String zoneType;

    @Column(name="NUMBER")
    private String number;

    @Column(name="INTERIOR")
    private String interior;

    @Column(name="LOT")
    private String lot;

    @Column(name="DEPARTMENT")
    private String department;

    @Column(name="APPLE")
    private String apple;

    @Column(name="KILOMETER")
    private String kilometer;

    @Column(name="OBS")
    private String obs;

}
