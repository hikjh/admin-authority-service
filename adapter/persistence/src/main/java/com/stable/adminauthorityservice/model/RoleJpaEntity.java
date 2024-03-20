package com.stable.adminauthorityservice.model;

import com.stable.adminauthorityservice.domain.type.RoleType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "role")
@Entity
public class RoleJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.ALL)
    private List<RolePermissionJpaEntity> rolePermissions;

    @Builder
    public RoleJpaEntity(Long id, RoleType roleType, String description, List<RolePermissionJpaEntity> rolePermissions) {
        this.id = id;
        this.roleType = roleType;
        this.description = description;
        this.rolePermissions = rolePermissions;
    }
}
