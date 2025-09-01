package com.malgn.application.users.required;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.malgn.application.users.model.UserResult;

public interface UserClient {

    Page<UserResult> getUsers(Pageable pageable);

    UserResult getUser(String id);

}
