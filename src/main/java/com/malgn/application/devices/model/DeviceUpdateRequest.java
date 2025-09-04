package com.malgn.application.devices.model;

import lombok.Builder;

@Builder
public record DeviceUpdateRequest(DeviceStatus status) {
}
