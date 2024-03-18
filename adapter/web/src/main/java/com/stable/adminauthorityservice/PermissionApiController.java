package com.stable.adminauthorityservice;

import com.stable.adminauthorityservice.permission.port.input.CreatePermissionUseCase;
import com.stable.adminauthorityservice.permission.port.input.dto.CreatePermissionCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.stable.adminauthorityservice.dto.PermissionClient.CreatePermissionRequest;
import static com.stable.adminauthorityservice.permission.port.input.dto.CreatePermissionCommand.of;

@RequiredArgsConstructor
@RequestMapping("/api/v1/authority/permissions")
@RestController
public class PermissionApiController {

    private final CreatePermissionUseCase createPermissionUseCase;

    @PostMapping
    public void createPermission(@RequestBody CreatePermissionRequest request) {
        CreatePermissionCommand command = of(request.resource(), request.actionType(), request.codeType(), request.description());
        createPermissionUseCase.createPermission(command);
    }
}
