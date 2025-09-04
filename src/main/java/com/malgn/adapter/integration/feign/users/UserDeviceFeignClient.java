package com.malgn.adapter.integration.feign.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.users.model.UserDeviceProvideRequest;

@FeignClient(name = "on-time-resources-management-api", contextId = "on-time-resources-management-api-users-devices", path = "api/v1/users")
public interface UserDeviceFeignClient {

    @PostMapping(path = "{id}/devices/{deviceId}")
    DeviceResult provide(@PathVariable String id, @PathVariable String deviceId,
        @RequestBody UserDeviceProvideRequest provideRequest);

}
