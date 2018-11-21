
package com.leysoft.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.leysoft.model.Profile;

public class SecurityUtils {

    private SecurityUtils() {
    }

    public static User getPrincipal() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Profile getProfile() {
        User user = getPrincipal();
        return new Profile(user.getUsername(), user.getUsername());
    }
}
