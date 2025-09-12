package com.malgn.application.software.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Builder;

@Builder
public record SoftwareResult(String id,
                             String teamId,
                             SoftwarePlatform platform,
                             String name,
                             String description,
                             String manufacturer,
                             String version,
                             SoftwareStatus status,
                             Map<String, Object> options,
                             LocalDateTime purchaseDate,
                             String licenseKey,
                             LocalDateTime licenseStartDate,
                             LocalDateTime licenseEndDate,
                             LocalDateTime createdDate,
                             String createdBy,
                             LocalDateTime lastModifiedDate,
                             String lastModifiedBy) {
}
