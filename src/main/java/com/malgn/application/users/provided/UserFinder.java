package com.malgn.application.users.provided;

import com.malgn.application.users.model.UserResult;

public interface UserFinder {

    UserResult getUser(String id);

}
