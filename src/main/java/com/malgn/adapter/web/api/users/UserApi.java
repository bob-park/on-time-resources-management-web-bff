package com.malgn.adapter.web.api.users;

import java.util.Map;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.application.users.model.UserResult;
import com.malgn.application.users.provided.UserFinder;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserApi {

    private final UserFinder userFinder;

    @GetMapping(path = "me")
    public UserResult getUser(@AuthenticationPrincipal OidcUser user) {
        return userFinder.getUser(getId(user));
    }

    private String getId(OidcUser user) {
        Map<String, Object> userProfile = user.getUserInfo().getClaim(OidcScopes.PROFILE);
        return String.valueOf(userProfile.get("id"));
    }

}
