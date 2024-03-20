package com.stable.adminauthorityservice;

import com.stable.adminauthorityservice.dto.RoleClient.CreateRoleRequest;
import com.stable.adminauthorityservice.role.port.input.CreateRoleCommand;
import com.stable.adminauthorityservice.role.port.input.CreateRoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/authority/roles")
@RestController
public class RoleApiController {

    private final CreateRoleUseCase createRoleUseCase;

    @PostMapping
    public void createRole(@RequestBody CreateRoleRequest request) {
        CreateRoleCommand command = CreateRoleCommand.of(request.roleType(), request.permissionIds());
        createRoleUseCase.createRole(command);
    }
}
