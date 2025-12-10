package com.auth.Login_Authenticator.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    /**
     * Nombre del usuario.
     */
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String name;
    /**
     * Correo electronico del usuario
     * Debe ser unico y valido
     */
    @NotBlank(message = "El emain es obligarotio")
    @Email(message = "El correo debe ser valido")
    @Column(unique = true)
    private String email;
    /**
     * Contraseña del usuario.
     * Debe tener al menos 6 caracteres.
     */
    @NotBlank(message = "la contraseña es obligatoaria")
    @Size(min = 6, message = "la contraseña debe tener almenos 6 caracteres")
    private String password;
    /**
     * Indica si el correo electroníco del usuario ha sido verificado.
     */
    @Column(name = "email_verificado")
    private boolean emailVerified = false;

}
