package com.octans.servicio;

import com.octans.dao.UsuarioDao;
import com.octans.model.Usuario;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase de implementación CRUD
 * @author Mario Segura
 */
@Service
@NoArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional()
    public Usuario encontrarUsuarioPorNombre(String nombre) {
        return usuarioDao.findByNombre(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> encontrarUsuarioPorId(Long idUsuario) {
        return usuarioDao.findById(idUsuario);
    }

    @Override
    public void deleteById(long id) {
        usuarioDao.deleteById(id);
    }    
    
}
