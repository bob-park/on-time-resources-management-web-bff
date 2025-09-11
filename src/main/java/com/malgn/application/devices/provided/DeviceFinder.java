package com.malgn.application.devices.provided;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.malgn.application.devices.model.DeviceDashboardResult;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;

public interface DeviceFinder {

    DeviceDashboardResult getDashboard();

    Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable);

    DeviceResult getDevice(String id);

}
