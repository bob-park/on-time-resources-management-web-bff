package com.malgn.adapter.web.api.users;

import java.util.Map;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.model.UserSearchRequest;
import com.malgn.application.users.provided.UserFinder;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserApi {

    private final UserFinder userFinder;

    @GetMapping(path = "")
    public Page<UserResult> getUsers(UserSearchRequest searchRequest, Pageable pageable) {
        return userFinder.getUsers(searchRequest, pageable);
    }

    @GetMapping(path = "me")
    public UserResult getUser(@AuthenticationPrincipal OidcUser user) {
        return userFinder.getUser(getId(user));
    }

    @GetMapping(path = "{id}/avatar")
    public Object getUserAvatar(@PathVariable String id) {
        return userFinder.getUserAvatar(id);
    }

    private String getId(OidcUser user) {
        Map<String, Object> userProfile = user.getUserInfo().getClaim(OidcScopes.PROFILE);
        return String.valueOf(userProfile.get("id"));
    }

}
