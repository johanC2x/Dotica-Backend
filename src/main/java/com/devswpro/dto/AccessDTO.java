package com.devswpro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccessDTO {
    private Integer idAccess;
    private String appName;
    private String token;
    private String webSite;
    private String description;
}