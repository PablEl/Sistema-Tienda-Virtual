package com.mx.usuarioService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.usuarioService.VO.UsuarioRequestVO;
import com.mx.usuarioService.VO.UsuarioResponseVO;
import com.mx.usuarioService.dao.Usuarios;
import com.mx.usuarioService.dao.UsuariosRepositoryDao;

@Service
public class UsuariosAppImpl implements UsuariosApp{

    @Autowired
    private UsuariosRepositoryDao repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> mostrarTodos() {
        List<Usuarios> response = repository.findAll();
        if (response.isEmpty()) return null;
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseVO buscar(Integer id) {
        Optional<Usuarios> response = repository.findById(id);
        if (!response.isPresent()) return null;
        return new UsuarioResponseVO(
        response.get().getNombre(), 
        response.get().getApellidoPaterno(), 
        response.get().getApellidoMaterno(), 
        response.get().getEmail(), 
        response.get().getTelefono(), 
        response.get().getFechaRegistro());
    }

    @Override
    @Transactional(readOnly = false)
    @Modifying
    public Integer alta(UsuarioRequestVO usuario) {
        Usuarios usuarioEnviar = new Usuarios(
            usuario.getNombre(),
            usuario.getApellidoPaterno(), 
            usuario.getEmail(), 
            usuario.getTelefono(), 
            usuario.getFechaRegistro());
        return repository.saveAndFlush(usuarioEnviar).getIdUsuario();
    }

    @Override
    @Transactional(readOnly = false)
    @Modifying
    public Usuarios actualizacion(Integer id, Usuarios usuario) {
        if (!repository.findById(id).isPresent()) return null;
        return repository.saveAndFlush(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean eliminacion(Integer id) {
        if (!repository.findById(id).isPresent()) return false;
        repository.deleteById(id);
        return true;
    }

}
