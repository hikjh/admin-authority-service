package com.stable.adminauthorityservice.permission.entity;

import com.stable.adminauthorityservice.domain.entity.AggregateRoot;
import com.stable.adminauthorityservice.domain.type.PermissionActionType;
import com.stable.adminauthorityservice.domain.type.PermissionCodeType;
import com.stable.adminauthorityservice.domain.valueobject.PermissionId;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Permission extends AggregateRoot<PermissionId> {

    private final String resource;
    private final PermissionActionType actionType;
    private final PermissionCodeType codeType;
    private final String description;

    @Builder
    public Permission(PermissionId permissionId, String resource, PermissionActionType actionType, PermissionCodeType codeType, String description) {
        super.setId(permissionId);
        this.resource = resource;
        this.actionType = actionType;
        this.codeType = codeType;
        this.description = description;
    }

    public static Permission of(String resource, PermissionActionType actionType, PermissionCodeType codeType, String description) {
        return Permission.builder()
            .resource(resource)
            .actionType(actionType)
            .codeType(codeType)
            .description(description)
            .build();
    }
}
