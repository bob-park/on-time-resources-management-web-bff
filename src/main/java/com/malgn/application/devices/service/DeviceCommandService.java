package com.malgn.application.devices.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.provided.DeviceRegister;
import com.malgn.application.devices.required.DeviceClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeviceCommandService implements DeviceRegister {

    private final DeviceClient deviceClient;

    @Override
    public DeviceResult register(DeviceRegisterRequest request) {
        return deviceClient.registerDevice(request);
    }
}
