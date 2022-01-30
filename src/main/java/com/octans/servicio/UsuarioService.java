package com.octans.servicio;

import com.octans.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 * Clase CRUD
 * @author Mario Segura
 */
public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario encontrarUsuarioPorNombre(String nombre);
    
    public Optional<Usuario> encontrarUsuarioPorId(Long idUsuario);
    
    public void deleteById(long id);
}
