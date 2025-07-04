package com.mx.usuarioService.VO;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestVO implements Serializable{
    private String nombre;
    private String apellidoPaterno;
    private String email;
    private String telefono;
    private Date fechaRegistro;
}
