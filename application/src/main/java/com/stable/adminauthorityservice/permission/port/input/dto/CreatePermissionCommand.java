package com.stable.adminauthorityservice.permission.port.input.dto;

import com.stable.adminauthorityservice.domain.type.PermissionActionType;
import com.stable.adminauthorityservice.domain.type.PermissionCodeType;
import lombok.Builder;

@Builder
public record CreatePermissionCommand(
        String resource,
        PermissionActionType actionType,
        PermissionCodeType codeType,
        String description
) {
    public static CreatePermissionCommand of(String resource, String actionType, String codeType, String description) {
        return CreatePermissionCommand.builder()
                .resource(resource)
                .actionType(PermissionActionType.valueOf(actionType))
                .codeType(PermissionCodeType.valueOf(codeType))
                .description(description)
                .build();
    }
}
