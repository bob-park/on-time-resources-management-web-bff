package com.malgn.application.devices.model;

import lombok.Builder;

@Builder
public record DeviceDashboardResult(Long total,
                                    DeviceCategoryResult category,
                                    DeviceStatusResult status) {
}
