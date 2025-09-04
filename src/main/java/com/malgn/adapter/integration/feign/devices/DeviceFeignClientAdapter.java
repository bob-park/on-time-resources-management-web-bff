package com.malgn.adapter.integration.feign.devices;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.application.devices.model.DeviceUpdateRequest;
import com.malgn.application.devices.required.DeviceClient;

@RequiredArgsConstructor
@Component
public class DeviceFeignClientAdapter implements DeviceClient {

    private final DeviceFeignClient deviceClient;

    @Override
    public Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable) {
        return deviceClient.getDevices(searchRequest, pageable).toPage();
    }

    @Override
    public DeviceResult registerDevice(DeviceRegisterRequest registerRequest) {
        return deviceClient.registerDevice(registerRequest);
    }

    @Override
    public DeviceResult updateDevice(String id, DeviceUpdateRequest updateRequest) {
        return deviceClient.updateDevice(id, updateRequest);
    }
}
