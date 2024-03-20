package com.stable.adminauthorityservice.role.valueobject;

import com.stable.adminauthorityservice.role.entity.RolePermission;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RolePermissions {

    private final List<RolePermission> rolePermissions;

    @Builder
    public RolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public static RolePermissions of(List<RolePermission> rolePermissions) {
        return RolePermissions.builder()
                .rolePermissions(rolePermissions)
                .build();
    }
}
