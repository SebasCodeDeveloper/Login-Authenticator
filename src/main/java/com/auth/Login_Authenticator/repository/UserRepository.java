package com.auth.Login_Authenticator.repository;

import com.auth.Login_Authenticator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/*
 * Repositorio encargado de la conecion de la base de datos  para la
 * entidad User
 *
 * Extiende JpaRepository para obtener automáticamente
 * las operaciones CRUD básicas (save, findById, findAll, delete, etc.).
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /*
     * Busca un usuario por su correo electronco
     *
     * Spring JPA genera automaticamnet  la consulta
     * Basandoce en el nombre del metodo
     *
     * @param Eamil correo de usuario
     * @Retum optional que contiene el usuario existente o
     * Basio si no lo encuntra
     */
    Optional<User> findByEmail(String email);
}