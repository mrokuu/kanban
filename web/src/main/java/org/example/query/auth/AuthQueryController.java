package org.example.query.auth;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthQueryController {
    @GetMapping("/isEmailFree/{email}")
    public boolean isEmailFree() {
        return false;
    }
}
