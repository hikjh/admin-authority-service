package com.stable.adminauthorityservice;

import com.stable.adminauthorityservice.mapper.PermissionCommandJpaMapper;
import com.stable.adminauthorityservice.model.PermissionJpaEntity;
import com.stable.adminauthorityservice.permission.Permission;
import com.stable.adminauthorityservice.permission.port.output.PermissionCommandRepository;
import com.stable.adminauthorityservice.repository.PermissionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PermissionCommandPersistenceAdapter implements PermissionCommandRepository {

    private final PermissionCommandJpaMapper permissionCommandJpaMapper;
    private final PermissionJpaRepository permissionJpaRepository;

    @Override
    public void save(Permission permission) {
        PermissionJpaEntity permissionJpaEntity = permissionCommandJpaMapper.convertToPermissionJpaEntity(permission);
        permissionJpaRepository.save(permissionJpaEntity);
    }
}
