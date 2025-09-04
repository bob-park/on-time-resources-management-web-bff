package com.malgn.application.users.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.model.UserSearchRequest;
import com.malgn.application.users.provided.UserFinder;
import com.malgn.application.users.required.UserClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserQueryService implements UserFinder {

    private final UserClient userClient;

    @Override
    public UserResult getUser(String id) {
        return userClient.getUser(id);
    }

    @Override
    public Page<UserResult> getUsers(UserSearchRequest searchRequest, Pageable pageable) {
        return userClient.getUsers(searchRequest, pageable).map(user -> userClient.getUser(user.id()));
    }

    @Override
    public ResponseEntity<Resource> getUserAvatar(String uniqueId) {
        return userClient.getUserAvatar(uniqueId);
    }
}
