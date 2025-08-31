package com.malgn.application.devices.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class DeviceSearchRequest {

    private String name;
    private String description;
    private String teamId;
    private String deviceType;
    private String status;
    private String model;
    private String manufacturer;
    private String serialNumber;

    @Builder(toBuilder = true)
    private DeviceSearchRequest(String name, String description, String teamId, String deviceType, String status,
        String model, String manufacturer, String serialNumber) {
        this.name = name;
        this.description = description;
        this.teamId = teamId;
        this.deviceType = deviceType;
        this.status = status;
        this.model = model;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
    }
}
