
package com.leysoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.model.Profile;
import com.leysoft.util.SecurityUtils;

@RestController
@RequestMapping(
        value = {
            "/api"
        })
public class ProfileController {

    @GetMapping(
            value = {
                "/profile"
            })
    public ResponseEntity<Profile> profile() {
        return ResponseEntity.ok(SecurityUtils.getProfile());
    }
}
