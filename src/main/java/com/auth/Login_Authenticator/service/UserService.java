package com.auth.Login_Authenticator.service;

import com.auth.Login_Authenticator.model.LoginDto;

public interface UserService {

    /*
    * crear un usuario en base mi modelo LoginDto
    * @Param LoginDto Contiene los datos que seran usados para el registro
    * @Return LoginDto
     */
     LoginDto create(LoginDto rq);
}
