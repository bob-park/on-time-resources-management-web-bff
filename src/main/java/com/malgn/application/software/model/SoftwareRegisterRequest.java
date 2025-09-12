package com.malgn.application.software.model;

import java.time.LocalDate;
import java.util.Map;

public record SoftwareRegisterRequest(Long teamId,
                                      SoftwarePlatform platform,
                                      String name,
                                      String description,
                                      String manufacturer,
                                      String version,
                                      Map<String, Object> options,
                                      LocalDate purchaseDate,
                                      String licenseKey,
                                      LocalDate licenseStartDate,
                                      LocalDate licenseEndDate) {
}
