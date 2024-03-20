package com.stable.adminauthorityservice;

import com.stable.adminauthorityservice.mapper.RoleCommandJpaMapper;
import com.stable.adminauthorityservice.model.RoleJpaEntity;
import com.stable.adminauthorityservice.repository.RoleJpaRepository;
import com.stable.adminauthorityservice.role.entity.Role;
import com.stable.adminauthorityservice.role.port.output.RoleCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleCommandPersistenceAdapter implements RoleCommandRepository {

    private final RoleCommandJpaMapper mapper;
    private final RoleJpaRepository roleJpaRepository;

    @Override
    public void save(Role role) {
        RoleJpaEntity jpaEntity = mapper.convertToRoleJpaEntity(role);
        roleJpaRepository.save(jpaEntity);
    }
}
