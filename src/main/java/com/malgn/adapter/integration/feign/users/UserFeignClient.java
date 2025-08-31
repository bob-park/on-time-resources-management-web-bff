package com.malgn.adapter.integration.feign.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.malgn.application.users.model.UserResult;

@FeignClient(name = "auth-user-api", contextId = "auth-user-api", path = "api/v1/users")
public interface UserFeignClient {

    @GetMapping(path = "{id}")
    UserResult getUser(String id);

}
