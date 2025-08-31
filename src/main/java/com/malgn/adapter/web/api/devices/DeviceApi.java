package com.malgn.adapter.web.api.devices;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.application.devices.model.DeviceDashboardResult;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.application.devices.provided.DeviceFinder;

@RequiredArgsConstructor
@RestController
@RequestMapping("devices")
public class DeviceApi {

    private final DeviceFinder deviceFinder;

    @GetMapping(path = "")
    public Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable) {
        return deviceFinder.getDevices(searchRequest, pageable);
    }

    @GetMapping(path = "dashboard")
    public DeviceDashboardResult getDashboard() {
        return deviceFinder.getDashboard();
    }

}
