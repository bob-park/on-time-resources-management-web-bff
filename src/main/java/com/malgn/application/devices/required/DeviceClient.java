package com.malgn.application.devices.required;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;

public interface DeviceClient {

    Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable);

    DeviceResult registerDevice(DeviceRegisterRequest registerRequest);

}
