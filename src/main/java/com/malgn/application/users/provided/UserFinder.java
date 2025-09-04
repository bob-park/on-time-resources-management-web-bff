package com.malgn.application.users.provided;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.model.UserSearchRequest;

public interface UserFinder {

    UserResult getUser(String id);

    Page<UserResult> getUsers(UserSearchRequest searchRequest, Pageable pageable);

    ResponseEntity<Resource> getUserAvatar(String uniqueId);

}
