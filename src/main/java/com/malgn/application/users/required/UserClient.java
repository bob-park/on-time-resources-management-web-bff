package com.malgn.application.users.required;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.model.UserSearchRequest;

public interface UserClient {

    Page<UserResult> getUsers(UserSearchRequest searchRequest, Pageable pageable);

    UserResult getUser(String id);

    ResponseEntity<Resource> getUserAvatar(String uniqueId);

}
