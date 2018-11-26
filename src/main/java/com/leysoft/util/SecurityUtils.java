
package com.leysoft.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.leysoft.model.Profile;

public class SecurityUtils {

    private SecurityUtils() {
    }

    public static String getPrincipal() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Profile getProfile() {
        String user = getPrincipal();
        return new Profile(user, user);
    }
}
