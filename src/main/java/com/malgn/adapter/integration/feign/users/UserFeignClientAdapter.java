package com.malgn.adapter.integration.feign.users;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.required.UserClient;

@RequiredArgsConstructor
@Component
public class UserFeignClientAdapter implements UserClient {

    private final UserFeignClient userFeignClient;

    @Override
    public UserResult getUser(String id) {
        return userFeignClient.getUser(id);
    }
}
