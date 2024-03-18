package com.stable.adminauthorityservice.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PermissionCodeType {

    ADMIN_REGISTER_PERMISSION("관리자 권한 등록"),
    ADMIN_REGISTER_ROLE("관리자 역할 등록"),
    ADMIN_RETRIEVE_ROLE("관리자 역할 조회"),
    ;

    private final String description;
}
