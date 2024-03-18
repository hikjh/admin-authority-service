package com.stable.adminauthorityservice.permission.port.output;

import com.stable.adminauthorityservice.permission.Permission;

public interface PermissionCommandRepository {
    void save(Permission permission);
}
