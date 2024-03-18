package com.stable.adminauthorityservice.permission.port.input;

import com.stable.adminauthorityservice.permission.port.input.dto.CreatePermissionCommand;

public interface CreatePermissionUseCase {
    void createPermission(CreatePermissionCommand command);
}
