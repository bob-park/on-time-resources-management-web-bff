package com.malgn.application.devices.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.malgn.application.users.model.UserDeviceResult;

public record DeviceResult(String id,
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
                           UserDeviceResult user,
                           Map<String, Object> options,
                           LocalDateTime createdDate,
                           String createdBy,
                           LocalDateTime lastModifiedDate,
                           String lastModifiedBy) {
}
