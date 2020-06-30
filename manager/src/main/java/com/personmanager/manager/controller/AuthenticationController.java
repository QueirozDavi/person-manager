package com.personmanager.manager.controller;

import com.personmanager.manager.config.DTOMapper;
import com.personmanager.manager.config.security.JwtTokenProvider;
import com.personmanager.manager.domain.JwtAuthentication;
import com.personmanager.manager.domain.dto.JwtAuthenticationDTO;
import com.personmanager.manager.domain.dto.LoginDTO;
import com.personmanager.manager.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/authentication")
public class AuthenticationController implements MVCController {

    private final JwtTokenProvider tokenProvider;
    private final AuthenticationService service;
    private final DTOMapper mapper;

    @Autowired
    public AuthenticationController(JwtTokenProvider tokenProvider, DTOMapper mapper,
                                    AuthenticationService service) {
        this.tokenProvider = tokenProvider;
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/login")
    public JwtAuthenticationDTO authenticateUser(@Valid @RequestBody LoginDTO loginDTO) {
        Authentication authentication = service.getAuthentication(mapper.toLogin(loginDTO));
        String jwt = tokenProvider.generateJwt(authentication);
        return mapper.toJwtAuthenticationDTO(new JwtAuthentication(jwt));
    }
}
