package com.personmanager.manager.databuilder.builder;

import com.personmanager.manager.config.DTOMapper;
import com.personmanager.manager.domain.User;
import com.personmanager.manager.domain.dto.UserDTO;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        user = new User();
        user.setEmail("fabianasandramelo_@l3ambiental.com.br");
        user.setName("Fabiana Sandra Melo");
        user.setPassword("ggqdBeYFSC");
    }

    public User build(){
        return user;
    }

    public User userMock(){
        user.setActive(Boolean.TRUE);
        user.setId(123L);
        return user;
    }

    public UserDTO buildDTO(){
        return DTOMapper.INSTANCE.toUserDto(user);
    }
}
