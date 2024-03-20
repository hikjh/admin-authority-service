package com.stable.adminauthorityservice.dto;

import java.util.List;

public class RoleClient {

    public record CreateRoleRequest(
            String roleType,
            List<Long> permissionIds
    ) {}
}
