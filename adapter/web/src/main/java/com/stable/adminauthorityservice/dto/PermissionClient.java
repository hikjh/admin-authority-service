package com.stable.adminauthorityservice.dto;

public class PermissionClient {
    public record CreatePermissionRequest(
            String resource,
            String actionType,
            String codeType,
            String description
    ) {}
}
