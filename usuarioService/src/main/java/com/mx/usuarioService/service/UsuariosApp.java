package com.mx.usuarioService.service;

import java.util.List;

import com.mx.usuarioService.VO.UsuarioRequestVO;
import com.mx.usuarioService.VO.UsuarioResponseVO;
import com.mx.usuarioService.dao.Usuarios;

public interface UsuariosApp {

    List<Usuarios> mostrarTodos();

    UsuarioResponseVO buscar(Integer id);

    Integer alta(UsuarioRequestVO usuario);

    Usuarios actualizacion(Integer id, Usuarios usuario);

    boolean eliminacion(Integer id);

}
