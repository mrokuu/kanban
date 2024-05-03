package org.example.commands.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthCommandController {

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp() {
      return null;
    }

    @PostMapping("/loginGoogle")
    public String loginWithGoogle() throws Exception {
        return null;

    }

    @PostMapping("/loginFacebook")
    public String loginWithFacebook() throws Exception {
        return null;
    }

}
