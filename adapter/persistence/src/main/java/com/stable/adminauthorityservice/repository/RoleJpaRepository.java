package com.stable.adminauthorityservice.repository;

import com.stable.adminauthorityservice.model.RoleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaRepository extends JpaRepository<RoleJpaEntity, Long> {
}
