package com.malgn.application.devices.model;

import lombok.Builder;

@Builder
public record DeviceCategoryResult(Long laptop,
                                   Long desktop,
                                   Long monitor,
                                   Long server,
                                   Long tv,
                                   Long etc) {
}
