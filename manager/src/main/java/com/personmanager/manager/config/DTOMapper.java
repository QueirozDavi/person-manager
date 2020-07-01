package com.personmanager.manager.config;

import com.personmanager.manager.domain.JwtAuthentication;
import com.personmanager.manager.domain.Login;
import com.personmanager.manager.domain.User;
import com.personmanager.manager.domain.dto.JwtAuthenticationDTO;
import com.personmanager.manager.domain.dto.LoginDTO;
import com.personmanager.manager.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DTOMapper {

    DTOMapper INSTANCE = Mappers.getMapper( DTOMapper.class );

    LoginDTO toLoginDTO(Login entity);

    JwtAuthenticationDTO toJwtAuthenticationDTO(JwtAuthentication entity);

    Login toLogin(LoginDTO dto);

    UserDTO toUserDto(User entity);

}
