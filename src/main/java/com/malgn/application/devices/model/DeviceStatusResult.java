package com.malgn.application.devices.model;

import lombok.Builder;

@Builder
public record DeviceStatusResult(Long used,
                                 Long waiting,
                                 Long broken,
                                 Long repairing,
                                 Long export,
                                 Long lost) {
}
