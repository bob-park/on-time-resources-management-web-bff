package com.malgn.application.users.model;

import java.time.LocalDate;

public record UserDeviceProvideRequest(LocalDate startDate,
                                       LocalDate endDate) {
}
