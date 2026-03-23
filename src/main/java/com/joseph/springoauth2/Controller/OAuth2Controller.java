package com.joseph.springoauth2.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")

public class OAuth2Controller {

    @GetMapping()
    public Map<String,Object> user(@AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser == null) {
            return Map.of("authenticated", false);
        }
        return Map.of("name", oidcUser.getFullName(), "email", oidcUser.getEmail(), "sub", oidcUser.getSubject(), "authenticated", true);
    }
}