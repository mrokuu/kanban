package org.example.commands.auth;

public record CreateSignUpRequest(

        String Email,

        String Name,

        String Password
) {
}
