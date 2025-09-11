package com.malgn.application.devices.service;

import static com.malgn.application.devices.model.DeviceStatus.*;
import static com.malgn.application.devices.model.DeviceType.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.malgn.application.devices.model.DeviceCategoryResult;
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

        long total =
            deviceClient.getDevices(searchRequest, page).getTotalElements();

        DeviceCategoryResult categoryResult = getCategoryResult();
        DeviceStatusResult statusResult = getStatusResult();

        return DeviceDashboardResult.builder()
            .total(total)
            .category(categoryResult)
            .status(statusResult)
            .build();
    }

    @Override
    public Page<DeviceResult> getDevices(DeviceSearchRequest searchRequest, Pageable pageable) {
        return deviceClient.getDevices(searchRequest, pageable);
    }

    @Override
    public DeviceResult getDevice(String id) {
        return deviceClient.getDevice(id);
    }

    private DeviceStatusResult getStatusResult() {
        Pageable page = PageRequest.of(0, 1);

        DeviceSearchRequest searchRequest =
            DeviceSearchRequest.builder()
                .build();

        long used =
            deviceClient.getDevices(searchRequest.toBuilder().status(USED).build(), page).getTotalElements();
        long waiting =
            deviceClient.getDevices(searchRequest.toBuilder().status(WAITING).build(), page).getTotalElements();
        long broken =
            deviceClient.getDevices(searchRequest.toBuilder().status(BROKEN).build(), page).getTotalElements();
        long repairing =
            deviceClient.getDevices(searchRequest.toBuilder().status(REPAIRING).build(), page).getTotalElements();
        long export =
            deviceClient.getDevices(searchRequest.toBuilder().status(EXPORT).build(), page).getTotalElements();
        long lost = deviceClient.getDevices(searchRequest.toBuilder().status(LOST).build(), page).getTotalElements();

        return
            DeviceStatusResult.builder()
                .used(used)
                .waiting(waiting)
                .broken(broken)
                .repairing(repairing)
                .export(export)
                .lost(lost)
                .build();
    }

    private DeviceCategoryResult getCategoryResult() {

        Pageable page = PageRequest.of(0, 1);

        DeviceSearchRequest searchRequest =
            DeviceSearchRequest.builder()
                .build();

        long laptop =
            deviceClient.getDevices(
                    searchRequest.toBuilder().deviceType(LAPTOP).build(),
                    page)
                .getTotalElements();

        long desktop =
            deviceClient.getDevices(
                    searchRequest.toBuilder().deviceType(DESKTOP).build(),
                    page)
                .getTotalElements();

        long server =
            deviceClient.getDevices(
                    searchRequest.toBuilder().deviceType(SERVER).build(),
                    page)
                .getTotalElements();

        long tv =
            deviceClient.getDevices(
                    searchRequest.toBuilder().deviceType(TV).build(),
                    page)
                .getTotalElements();

        long monitor =
            deviceClient.getDevices(
                    searchRequest.toBuilder().deviceType(MONITOR).build(),
                    page)
                .getTotalElements();

        long etc =
            deviceClient.getDevices(
                    searchRequest.toBuilder().deviceType(ETC).build(),
                    page)
                .getTotalElements();

        return DeviceCategoryResult.builder()
            .laptop(laptop)
            .desktop(desktop)
            .server(server)
            .tv(tv)
            .monitor(monitor)
            .etc(etc)
            .build();
    }
}
