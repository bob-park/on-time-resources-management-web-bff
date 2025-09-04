package com.malgn.adapter.integration.feign.users;


import lombok.RequiredArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.model.UserSearchRequest;
import com.malgn.application.users.required.UserClient;

@RequiredArgsConstructor
@Component
public class UserFeignClientAdapter implements UserClient {

    private final UserFeignClient userFeignClient;

    @Override
    public Page<UserResult> getUsers(UserSearchRequest searchRequest, Pageable pageable) {
        return userFeignClient.getUsers(searchRequest, pageable).toPage();
    }

    @Override
    public UserResult getUser(String id) {
        return userFeignClient.getUser(id);
    }

    @Override
    public ResponseEntity<Resource> getUserAvatar(String uniqueId) {
        return userFeignClient.getUserAvatar(uniqueId);
    }
}
