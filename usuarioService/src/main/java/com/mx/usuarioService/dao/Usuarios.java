package com.mx.usuarioService.dao;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE USUARIOS(
ID_USUARIO NUMBER PRIMARY KEY,
NOMBRE VARCHAR2(80) NOT NULL,
APELLIDO_PATERNO VARCHAR2(80) NOT NULL,
APELLIDO_MATERNO VARCHAR2(80),
EMAIL VARCHAR2(100) NOT NULL UNIQUE,
TELEFONO VARCHAR2(20) NOT NULL,
FECHA_REGISTRO DATE NOT NULL
); */

@Entity
@Table(name = "USUARIOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {

    @Id
    @Column(name = "ID_USUARIO", columnDefinition = "NUMBER", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name = "NOMBRE", columnDefinition = "VARCHAR2(80)", nullable = false)
    private String nombre;
    @Column(name = "APELLIDO_PATERNO", columnDefinition = "VARCHAR2(80)", nullable = false)
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO", columnDefinition = "VARCHAR2(80)", nullable = true)
    private String apellidoMaterno;
    @Column(name = "EMAIL", columnDefinition = "VARCHAR2(100)", nullable = false)
    private String email;
    @Column(name = "TELEFONO", columnDefinition = "VARCHAR2(20)", nullable = false)
    private String telefono;

    @Column(name = "FECHA_REGISTRO", columnDefinition = "DATE", nullable = false)
    private Date fechaRegistro;

    public Usuarios(String nombre, String apellidoPaterno, String email, String telefono,
            Date fechaRegistro) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    
}
