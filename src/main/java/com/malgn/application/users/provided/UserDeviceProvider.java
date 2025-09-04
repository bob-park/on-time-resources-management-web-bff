package com.malgn.application.users.provided;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.users.model.UserDeviceProvideRequest;

public interface UserDeviceProvider {

    DeviceResult provide(String id, String deviceId, UserDeviceProvideRequest provideRequest);

}
