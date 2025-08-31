package com.malgn.application.users.required;

import com.malgn.application.users.model.UserResult;

public interface UserClient {

    UserResult getUser(String id);

}
