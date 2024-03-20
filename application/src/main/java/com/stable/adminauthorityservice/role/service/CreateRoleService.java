package com.stable.adminauthorityservice.role.service;

import com.stable.adminauthorityservice.role.entity.Role;
import com.stable.adminauthorityservice.role.port.input.CreateRoleCommand;
import com.stable.adminauthorityservice.role.port.input.CreateRoleUseCase;
import com.stable.adminauthorityservice.role.port.output.RoleCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CreateRoleService implements CreateRoleUseCase {

    private final RoleCommandRepository roleCommandRepository;

    @Override
    public void createRole(CreateRoleCommand command) {
        Role role = Role.of(command.roleType(), command.description(), command.permissionIds());
        roleCommandRepository.save(role);
    }
}
