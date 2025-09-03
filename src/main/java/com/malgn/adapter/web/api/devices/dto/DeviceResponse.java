package com.malgn.adapter.web.api.devices.dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Builder;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceStatus;
import com.malgn.application.devices.model.DeviceType;
import com.malgn.application.users.model.UserResult;

@Builder
public record DeviceResponse(String id,
                             String teamId,
                             DeviceType deviceType,
                             String name,
                             String description,
                             String model,
                             String manufacturer,
                             String serialNumber,
                             String os,
                             String osVersion,
                             String cpu,
                             Long memory,
                             Long storage,
                             DeviceStatus status,
                             LocalDateTime purchaseDate,
                             String ipAddress,
                             UserResult user,
                             Map<String, Object> options,
                             LocalDateTime createdDate,
                             String createdBy,
                             LocalDateTime lastModifiedDate,
                             String lastModifiedBy) {

    public static DeviceResponse from(DeviceResult result, UserResult user) {
        return DeviceResponse.builder()
            .id(result.id())
            .teamId(result.teamId())
            .deviceType(result.deviceType())
            .name(result.name())
            .description(result.description())
            .model(result.model())
            .manufacturer(result.manufacturer())
            .serialNumber(result.serialNumber())
            .os(result.os())
            .osVersion(result.osVersion())
            .cpu(result.cpu())
            .memory(result.memory())
            .storage(result.storage())
            .status(result.status())
            .purchaseDate(result.purchaseDate())
            .ipAddress(result.ipAddress())
            .user(user)
            .options(result.options())
            .createdDate(result.createdDate())
            .createdBy(result.createdBy())
            .lastModifiedDate(result.lastModifiedDate())
            .lastModifiedBy(result.lastModifiedBy())
            .build();
    }
}
