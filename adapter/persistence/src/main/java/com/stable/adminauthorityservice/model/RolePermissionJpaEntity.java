package com.stable.adminauthorityservice.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "role_permission")
@Entity
public class RolePermissionJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_permission_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleJpaEntity role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id")
    private PermissionJpaEntity permission;

    @Builder
    public RolePermissionJpaEntity(Long id, RoleJpaEntity role, PermissionJpaEntity permission) {
        this.id = id;
        this.role = role;
        this.permission = permission;
    }

    public void addRole(RoleJpaEntity roleJpaEntity) {
        this.role = roleJpaEntity;
    }
}
