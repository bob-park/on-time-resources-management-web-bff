package com.malgn.application.users.required;

import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.users.model.UserDeviceProvideRequest;

public interface UserDeviceClient {

    DeviceResult provide(String id, String deviceId, UserDeviceProvideRequest provideRequest);

}
