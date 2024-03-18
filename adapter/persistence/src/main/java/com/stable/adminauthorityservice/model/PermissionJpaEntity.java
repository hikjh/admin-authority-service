package com.stable.adminauthorityservice.model;

import com.stable.adminauthorityservice.domain.type.PermissionActionType;
import com.stable.adminauthorityservice.domain.type.PermissionCodeType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "permission")
@Entity
public class PermissionJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id")
    private Long id;
    private String resource;
    @Enumerated(EnumType.STRING)
    private PermissionActionType actionType;
    @Enumerated(EnumType.STRING)
    private PermissionCodeType codeType;
    private String description;

    @Builder
    public PermissionJpaEntity(Long id, String resource, PermissionActionType actionType, PermissionCodeType codeType, String description) {
        this.id = id;
        this.resource = resource;
        this.actionType = actionType;
        this.codeType = codeType;
        this.description = description;
    }
}
