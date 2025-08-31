package com.malgn.application.users.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.malgn.application.users.model.UserResult;
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
}
