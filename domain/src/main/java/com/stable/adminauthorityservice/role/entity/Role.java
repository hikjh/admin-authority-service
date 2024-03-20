package com.stable.adminauthorityservice.role.entity;

import com.stable.adminauthorityservice.domain.entity.AggregateRoot;
import com.stable.adminauthorityservice.domain.type.RoleType;
import com.stable.adminauthorityservice.domain.valueobject.PermissionId;
import com.stable.adminauthorityservice.domain.valueobject.RoleId;
import com.stable.adminauthorityservice.role.valueobject.RolePermissions;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Role extends AggregateRoot<RoleId> {

    private final RoleType roleType;
    private final String description;
    private final RolePermissions rolePermissions;

    @Builder
    public Role(RoleId roleId, RoleType roleType, String description, RolePermissions rolePermissions) {
        super.setId(roleId);
        this.roleType = roleType;
        this.description = description;
        this.rolePermissions = rolePermissions;
    }

    public static Role of(RoleType roleType, String description, List<PermissionId> permissionIds) {
        return Role.builder()
                .roleType(roleType)
                .description(description)
                .rolePermissions(convertToRolePermissions(permissionIds))
                .build();
    }

    private static RolePermissions convertToRolePermissions(List<PermissionId> permissionIds) {
        return RolePermissions.of(permissionIds.stream()
                .map(RolePermission::of)
                .collect(Collectors.toList()));
    }
}
