package com.auth.Login_Authenticator.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDto {
    /*
     * No mbre del usuario
     *
     * No puede ir basio
     */
    @NotBlank(message = "Este campo es obligatorio")
    private String name;

    /*
     * Correo electronico de usuario
     *
     * No puede ir basio y debe cumplir con un formato de email.
     */
    @NotBlank(message = "Este campo es obligatorio")
    @Email(message = "Formato invaldio")
    private String email;

    /*
     * Contraseña de usuario
     *
     * Debe contener como minimo 6 caractes y no puiede ir basia
     */
    @NotBlank(message = "Este campo es obligatorio")
    @Size(min = 6, max = 6, message = "La contraseña debe tener minimo 6 caracteres")
    private String password;

}
