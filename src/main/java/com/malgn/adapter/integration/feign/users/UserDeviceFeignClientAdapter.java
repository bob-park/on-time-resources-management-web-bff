package com.malgn.adapter.integration.feign.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.users.model.UserDeviceProvideRequest;
import com.malgn.application.users.required.UserDeviceClient;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserDeviceFeignClientAdapter implements UserDeviceClient {

    private final UserDeviceFeignClient userDeviceClient;

    @Override
    public DeviceResult provide(String id, String deviceId, UserDeviceProvideRequest provideRequest) {
        return userDeviceClient.provide(id, deviceId, provideRequest);
    }
}
