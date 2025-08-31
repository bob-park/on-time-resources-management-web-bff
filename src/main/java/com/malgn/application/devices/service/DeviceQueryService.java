package com.malgn.application.devices.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.malgn.application.devices.model.DeviceDashboardResult;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.application.devices.model.DeviceStatusResult;
import com.malgn.application.devices.provided.DeviceFinder;
import com.malgn.application.devices.required.DeviceClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeviceQueryService implements DeviceFinder {

    private final DeviceClient deviceClient;

    @Override
    public DeviceDashboardResult getDashboard() {

        Pageable page = PageRequest.of(0, 1);

        DeviceSearchRequest searchRequest =
            DeviceSearchRequest.builder()
                .build();

        long total = deviceClient.getDevices(searchRequest, page).getTotalElements();
        long used = deviceClient.getDevices(searchRequest.toBuilder().status("USED").build(), page).getTotalElements();
        long waiting = deviceClient.getDevices(searchRequest.toBuilder().status("WAITING").build(), page).getTotalElements();
        long broken = deviceClient.getDevices(searchRequest.toBuilder().status("BROKEN").build(), page).getTotalElements();
        long repairing = deviceClient.getDevices(searchRequest.toBuilder().status("REPAIRING").build(), page).getTotalElements();
        long export = deviceClient.getDevices(searchRequest.toBuilder().status("EXPORT").build(), page).getTotalElements();
        long lost = deviceClient.getDevices(searchRequest.toBuilder().status("LOST").build(), page).getTotalElements();

        return DeviceDashboardResult.builder()
            .total(total)
            .status(
                DeviceStatusResult.builder()
                    .used(used)
                    .waiting(waiting)
                    .broken(broken)
                    .repairing(repairing)
                    .export(export)
                    .lost(lost)
                    .build())
            .build();
    }

    @Override
    public Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable) {
        return deviceClient.getDevices(searchRequest, pageable);
    }
}
