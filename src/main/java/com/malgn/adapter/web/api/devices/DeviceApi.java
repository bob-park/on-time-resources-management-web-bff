package com.malgn.adapter.web.api.devices;

import static com.malgn.adapter.web.api.devices.dto.DeviceResponse.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import com.malgn.adapter.web.api.devices.dto.DeviceResponse;
import com.malgn.application.devices.model.DeviceDashboardResult;
import com.malgn.application.devices.model.DeviceRegisterRequest;
import com.malgn.application.devices.model.DeviceResult;
import com.malgn.application.devices.model.DeviceSearchRequest;
import com.malgn.application.devices.model.DeviceUpdateRequest;
import com.malgn.application.devices.provided.DeviceFinder;
import com.malgn.application.devices.provided.DeviceRegister;
import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.required.UserClient;

@RequiredArgsConstructor
@RestController
@RequestMapping("devices")
public class DeviceApi {

    private final UserClient userClient;
    private final DeviceFinder deviceFinder;

    private final DeviceRegister deviceRegister;

    @GetMapping(path = "")
    public Page<DeviceResponse> getDevices(DeviceSearchRequest searchRequest, Pageable pageable) {
        Page<DeviceResult> result = deviceFinder.getDevices(searchRequest, pageable);

        List<UserResult> users = Lists.newArrayList();

        return result.map(
            item ->
                from(
                    item,
                    users.stream()
                        .filter(user -> item.user() != null && user.id().equals(item.user().userId()))
                        .findAny()
                        .orElseGet(() -> {
                            if (item.user() == null) {
                                return null;
                            }

                            UserResult user = userClient.getUser(item.user().userId());

                            users.add(user);

                            return user;
                        }))
        );

    }

    @GetMapping(path = "dashboard")
    public DeviceDashboardResult getDashboard() {
        return deviceFinder.getDashboard();
    }

    @PostMapping(path = "")
    public DeviceResponse register(@RequestBody DeviceRegisterRequest registerRequest) {
        DeviceResult result = deviceRegister.register(registerRequest);

        return from(result, null);
    }

    @PutMapping(path = "{id}")
    public DeviceResponse update(@PathVariable String id, @RequestBody DeviceUpdateRequest updateRequest) {

        DeviceResult result = deviceRegister.update(id, updateRequest);

        return from(result, null);
    }
}
