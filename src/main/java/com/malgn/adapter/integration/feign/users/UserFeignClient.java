package com.malgn.adapter.integration.feign.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.malgn.application.users.model.UserResult;
import com.malgn.common.model.SimplePageImpl;

@FeignClient(name = "auth-user-api", contextId = "auth-user-api", path = "api/v1/users")
public interface UserFeignClient {

    @GetMapping(path = "")
    SimplePageImpl<UserResult> getUsers(Pageable pageable);

    @GetMapping(path = "{id}")
    UserResult getUser(@PathVariable String id);


}
