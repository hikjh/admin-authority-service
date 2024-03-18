package com.stable.adminauthorityservice.repository;

import com.stable.adminauthorityservice.model.PermissionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionJpaRepository extends JpaRepository<PermissionJpaEntity, Long> {
}
