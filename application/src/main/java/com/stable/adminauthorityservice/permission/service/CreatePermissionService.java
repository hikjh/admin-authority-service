package com.stable.adminauthorityservice.permission.service;

import com.stable.adminauthorityservice.permission.Permission;
import com.stable.adminauthorityservice.permission.port.input.CreatePermissionUseCase;
import com.stable.adminauthorityservice.permission.port.input.dto.CreatePermissionCommand;
import com.stable.adminauthorityservice.permission.port.output.PermissionCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CreatePermissionService implements CreatePermissionUseCase {

    private final PermissionCommandRepository permissionCommandRepository;

    @Override
    public void createPermission(CreatePermissionCommand command) {
        Permission permission = Permission.of(command.resource(), command.actionType(), command.codeType(), command.description());
        permissionCommandRepository.save(permission);
    }
}
