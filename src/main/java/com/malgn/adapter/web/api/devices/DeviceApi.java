package com.malgn.adapter.web.api.devices;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.adapter.web.api.devices.dto.DeviceResponse;
import com.malgn.application.devices.model.DeviceDashboardResult;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.application.devices.provided.DeviceFinder;
import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.required.UserClient;

@RequiredArgsConstructor
@RestController
@RequestMapping("devices")
public class DeviceApi {

    private final UserClient userClient;
    private final DeviceFinder deviceFinder;

    @GetMapping(path = "")
    public Page<DeviceResponse> getDevices(DeviceSearchRequest searchRequest, Pageable pageable) {
        Page<DeviceResult> result = deviceFinder.getDevices(searchRequest, pageable);

        List<UserResult> users = userClient.getUsers(PageRequest.of(0, 100)).getContent();

        return result.map(
            item ->
                DeviceResponse.from(
                    item,
                    users.stream()
                        .filter(user -> item.user() != null && user.id().equals(item.user().userId()))
                        .findAny()
                        .orElse(null))
        );

    }

    @GetMapping(path = "dashboard")
    public DeviceDashboardResult getDashboard() {
        return deviceFinder.getDashboard();
    }

}
