package com.malgn.application.devices.provided;

import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceUpdateRequest;

public interface DeviceRegister {

    DeviceResult register(DeviceRegisterRequest request);

    DeviceResult update(String id, DeviceUpdateRequest updateRequest);

}
