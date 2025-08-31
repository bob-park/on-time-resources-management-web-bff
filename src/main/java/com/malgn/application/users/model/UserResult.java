package com.malgn.application.users.model;

import java.time.LocalDateTime;

import com.malgn.auth.model.RoleResponse;

public record UserResult(String id,
                         String userId,
                         String username,
                         RoleResponse role,
                         String email,
                         GroupResult group,
                         PositionResult position,
                         Boolean isDeleted,
                         LocalDateTime createdDate,
                         String createdBy,
                         LocalDateTime lastModifiedDate,
                         String lastModifiedBy) {
}
