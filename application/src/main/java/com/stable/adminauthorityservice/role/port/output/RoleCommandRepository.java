package com.stable.adminauthorityservice.role.port.output;

import com.stable.adminauthorityservice.role.entity.Role;

public interface RoleCommandRepository {
    void save(Role role);
}
