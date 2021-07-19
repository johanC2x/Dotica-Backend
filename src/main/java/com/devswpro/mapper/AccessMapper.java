package com.devswpro.mapper;

import com.devswpro.dto.AccessDTO;
import com.devswpro.dto.ErrorDTO;
import com.devswpro.model.IntAccess;

import java.util.Objects;

public class AccessMapper {
    public static AccessDTO map(IntAccess access){
        if(Objects.isNull(access)){
            return null;
        }
        return AccessDTO.builder()
                .idAccess(access.getIdAccess())
                .appName(access.getAppName())
                .description(access.getDescription())
                .token(access.getToken())
                .webSite(access.getWebSite())
                .build();
    }

    public static ErrorDTO mapError(String msg){
        return ErrorDTO.builder()
                .error(msg)
                .build();
    }
}
