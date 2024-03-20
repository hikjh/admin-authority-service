package com.stable.adminauthorityservice.role.port.input;

import com.stable.adminauthorityservice.domain.type.RoleType;
import com.stable.adminauthorityservice.domain.valueobject.PermissionId;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record CreateRoleCommand(
        RoleType roleType,
        String description,
        List<PermissionId> permissionIds
) {
    public static CreateRoleCommand of(String roleType, List<Long> permissionIds) {
        return CreateRoleCommand.builder()
                .roleType(RoleType.valueOf(roleType))
                .description(RoleType.valueOf(roleType).getDescription())
                .permissionIds(convertToPermissionIds(permissionIds))
                .build();
    }

    private static List<PermissionId> convertToPermissionIds(List<Long> permissionIds) {
        return permissionIds.stream()
                .map(PermissionId::new)
                .collect(Collectors.toList());
    }
}
