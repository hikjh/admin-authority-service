package com.stable.adminauthorityservice.role.entity;

import com.stable.adminauthorityservice.domain.entity.BaseEntity;
import com.stable.adminauthorityservice.domain.valueobject.PermissionId;
import com.stable.adminauthorityservice.domain.valueobject.RoleId;
import com.stable.adminauthorityservice.domain.valueobject.RolePermissionId;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RolePermission extends BaseEntity<RolePermissionId> {

    private final RoleId roleId;
    private final PermissionId permissionId;

    @Builder
    public RolePermission(RolePermissionId rolePermissionId, RoleId roleId, PermissionId permissionId) {
        super.setId(rolePermissionId);
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public static RolePermission of(PermissionId permissionId) {
        return RolePermission.builder()
                .permissionId(permissionId)
                .build();
    }
}
