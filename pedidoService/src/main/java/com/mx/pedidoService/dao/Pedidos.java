package com.mx.pedidoService.dao;

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

/*CREATE TABLE PEDIDOS(
ID_PEDIDO NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY,
ID_USUARIO NUMBER NOT NULL,
FECHA_PEDIDO DATE NOT NULL,
TOTAL FLOAT NOT NULL,
ESTADO VARCHAR2(30) DEFAULT 'PENDIENTE'
); */
@Entity
@Table(name = "PEDIDOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {
    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "FECHA_PEDIDO")
    private Date fechaPedido;
    @Column(name = "TOTAL")
    private Float total;
    @Column(name = "ESTADO")
    private String estado;

}
