package com.malgn.application.devices.required;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.application.devices.model.DeviceUpdateRequest;

public interface DeviceClient {


    DeviceResult getDevice(String id);

    Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable);

    DeviceResult registerDevice(DeviceRegisterRequest registerRequest);

    DeviceResult updateDevice(String id, DeviceUpdateRequest updateRequest);

}
