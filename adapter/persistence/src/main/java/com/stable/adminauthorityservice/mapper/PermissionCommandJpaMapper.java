package com.stable.adminauthorityservice.mapper;

import com.stable.adminauthorityservice.model.PermissionJpaEntity;
import com.stable.adminauthorityservice.permission.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionCommandJpaMapper {
    public PermissionJpaEntity convertToPermissionJpaEntity(Permission permission) {
        return PermissionJpaEntity.builder()
                .resource(permission.getResource())
                .actionType(permission.getActionType())
                .codeType(permission.getCodeType())
                .description(permission.getDescription())
                .build();
    }
}
