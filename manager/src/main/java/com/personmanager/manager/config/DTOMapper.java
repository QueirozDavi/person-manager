package com.personmanager.manager.config;

import com.personmanager.manager.domain.JwtAuthentication;
import com.personmanager.manager.domain.Login;
import com.personmanager.manager.domain.dto.JwtAuthenticationDTO;
import com.personmanager.manager.domain.dto.LoginDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DTOMapper {

    JwtAuthenticationDTO toJwtAuthenticationDTO(JwtAuthentication entity);

    Login toLogin(LoginDTO dto);

}
