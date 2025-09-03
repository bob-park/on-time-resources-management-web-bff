package com.malgn.application.devices.model;

import java.time.LocalDate;

public record DeviceRegisterRequest(String teamId,
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
                                    String ipAddress,
                                    LocalDate purchaseDate) {
}
