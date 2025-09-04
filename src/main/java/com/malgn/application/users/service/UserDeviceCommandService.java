package com.malgn.application.users.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.users.model.UserDeviceProvideRequest;
import com.malgn.application.users.provided.UserDeviceProvider;
import com.malgn.application.users.required.UserDeviceClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDeviceCommandService implements UserDeviceProvider {

    private final UserDeviceClient userDeviceClient;

    @Override
    public DeviceResult provide(String id, String deviceId, UserDeviceProvideRequest provideRequest) {
        return userDeviceClient.provide(id, deviceId, provideRequest);
    }
}
