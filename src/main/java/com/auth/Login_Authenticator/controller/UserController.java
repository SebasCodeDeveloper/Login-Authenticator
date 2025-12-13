package com.auth.Login_Authenticator.controller;

import com.auth.Login_Authenticator.model.LoginDto;
import com.auth.Login_Authenticator.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin     // Permite peticiones desde cualquier origen (CORS)
@RequestMapping("/api/users") //Ruata facil  para todos los endpoints de usuasrios
public class UserController {

    /*
     *Servicio que contiene la logica de negocio relacionada
     * con los usuarios
     */
    private final UserService userService;

    /*
     *inyecion d dependecias mediante los constructores.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     * Endpoint para crear un usuario
     *
     * Recibe un objeto LoginDto desde el body de la peticion,
     * valida sus campos usando @Valid y delega la creacion al
     * usuario
     *
     * @param Rq datos de usuario creado
     * @return ResponseEntity con el usuario creado
     */
    @PostMapping("/create")
    public ResponseEntity<LoginDto> create(@RequestBody @Valid LoginDto Rq) {
        return ResponseEntity.ok(userService.create(Rq));
    }

}
