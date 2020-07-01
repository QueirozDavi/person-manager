package com.personmanager.manager.databuilder.builder;

import com.personmanager.manager.config.DTOMapper;
import com.personmanager.manager.domain.Login;
import com.personmanager.manager.domain.dto.LoginDTO;

public class LoginBuilder {

	private Login login;
	
	public LoginBuilder() {
		login = new Login();
		login.setEmail("fabianasandramelo_@l3ambiental.com.br");
		login.setPassword("ggqdBeYFSC");
	}
	
	public Login build(){
		return login;
    }

	public LoginDTO buildDTO(){
		return DTOMapper.INSTANCE.toLoginDTO(login);
	}
}