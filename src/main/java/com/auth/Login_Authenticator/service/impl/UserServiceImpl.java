package com.auth.Login_Authenticator.service.impl;

import com.auth.Login_Authenticator.entity.User;
import com.auth.Login_Authenticator.model.LoginDto;
import com.auth.Login_Authenticator.repository.UserRepository;
import com.auth.Login_Authenticator.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementación del servicio de usuarios.
 * <p>
 * Contiene la lógica de negocio relacionada con
 * la creación y validación de usuarios.
 */
@Service
public class UserServiceImpl implements UserService {
    /*
     * Repositorio para el acceso a datos de usuario
     */
    private final UserRepository userRepository;

    /*
     * inyeccion de dependecias por constructos.
     *
     * @param userRepository repositorio de usuarios
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * Crea un usuario nuevo
     *
     * Valida que el correo no este registrado
     * Si el correo ya existe lanza una exception
     *
     * @param Rq ocjeto con la informacion del usuario
     * @return LoginDto con los datos usuario cread
     */
    @Override
    public LoginDto create(LoginDto rq) {
        /*
         *  Busca un usuario con el mismo email
         */
        Optional<User> usuarioExistente = userRepository.findByEmail(rq.getEmail());

        //si el usuario ya existe, se detiene el proecso
        if (!usuarioExistente.isEmpty()) {
            throw new RuntimeException("Ya hay un usuario creado con este correo");
        }
        //Crea entidad User y mapear datos desde el DTO
        User user = new User();
        user.setName(rq.getName());
        user.setEmail(rq.getEmail());
        user.setPassword(rq.getPassword());
        //Guarda el usuario en la bese de datos
        User userSaved = userRepository.save(user);

        //Crea el DTO de respuesta
        LoginDto userDto = new LoginDto();
        userDto.setName(userSaved.getName());
        userDto.setEmail(userSaved.getEmail());
        userDto.setPassword(userSaved.getPassword());

        return userDto;
    }

}
