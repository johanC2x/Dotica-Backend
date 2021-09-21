package com.devswpro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyDTO {
    private String ruc;
    private String name;
    private String status;
    private String residenceStatus;
    private String location;
    private String roadType;
    private String streetName;
    private String zoneCode;
    private String zoneType;
}