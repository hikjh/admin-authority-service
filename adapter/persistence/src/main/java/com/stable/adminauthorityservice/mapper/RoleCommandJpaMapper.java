package com.stable.adminauthorityservice.mapper;

import com.stable.adminauthorityservice.model.PermissionJpaEntity;
import com.stable.adminauthorityservice.model.RoleJpaEntity;
import com.stable.adminauthorityservice.model.RolePermissionJpaEntity;
import com.stable.adminauthorityservice.role.entity.Role;
import com.stable.adminauthorityservice.role.entity.RolePermission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RoleCommandJpaMapper {
    public RoleJpaEntity convertToRoleJpaEntity(Role role) {
        RoleJpaEntity roleJpaEntity = RoleJpaEntity.builder()
                .roleType(role.getRoleType())
                .description(role.getDescription())
                .rolePermissions(Objects.isNull(role.getRolePermissions()) ? null : convertToRolePermissionJpaEntities(role))
                .build();

        roleJpaEntity.getRolePermissions().forEach(rolePermissionJpaEntity -> rolePermissionJpaEntity.addRole(roleJpaEntity));
        return roleJpaEntity;
    }

    private List<RolePermissionJpaEntity> convertToRolePermissionJpaEntities(Role role) {
        return role.getRolePermissions().getRolePermissions().stream()
                .map(this::convertToRolePermission)
                .collect(Collectors.toList());
    }

    private RolePermissionJpaEntity convertToRolePermission(RolePermission rolePermission) {
        return RolePermissionJpaEntity.builder()
                .permission(convertToPermissionJpaEntity(rolePermission))
                .build();
    }

    private PermissionJpaEntity convertToPermissionJpaEntity(RolePermission rolePermission) {
        return PermissionJpaEntity.builder()
                .id(rolePermission.getPermissionId().getId())
                .build();
    }
}
