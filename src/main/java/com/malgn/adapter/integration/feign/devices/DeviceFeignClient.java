package com.malgn.adapter.integration.feign.devices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.common.model.SimplePageImpl;

@FeignClient(name = "on-time-resources-management-api", contextId="on-time-resources-management-api-devices", path = "api/v1/devices")
public interface DeviceFeignClient {

    @GetMapping(path = "")
    SimplePageImpl<DeviceResult> getDevices(@SpringQueryMap DeviceSearchRequest searchRequest, Pageable pageable);

    @PostMapping(path = "")
    DeviceResult registerDevice(@RequestBody DeviceRegisterRequest registerRequest);
}
