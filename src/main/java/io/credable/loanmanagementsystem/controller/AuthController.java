package io.credable.loanmanagementsystem.controller;


import io.credable.loanmanagementsystem.data.dto.LoginDTO;
import io.credable.loanmanagementsystem.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    @PostMapping("/token")
    public String token(@RequestBody LoginDTO userLogin) {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        return tokenService.generateToken(authentication);
    }
}
