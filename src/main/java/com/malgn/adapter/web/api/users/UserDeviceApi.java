package com.malgn.adapter.web.api.users;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.users.model.UserDeviceProvideRequest;
import com.malgn.application.users.provided.UserDeviceProvider;

@RequiredArgsConstructor
@RestController
@RequestMapping("users/{id}/devices")
public class UserDeviceApi {

    private final UserDeviceProvider userDeviceProvider;

    @PostMapping(path = "{deviceId}")
    public DeviceResult provideDevice(@PathVariable String id, @PathVariable String deviceId, @RequestBody UserDeviceProvideRequest providerRequest) {
        return userDeviceProvider.provide(id, deviceId, providerRequest);
    }

}
