package com.octans.servicio;

import com.octans.dto.UsuarioDto;
import java.util.List;

/**
 * Clase CRUD
 * @author Mario Segura
 */
public interface UsuarioService {
    public List<UsuarioDto> listarUsuarios();
    
    public void guardar(UsuarioDto usuarioDto);
    
    public void eliminar(UsuarioDto usuarioDto);
    
    public UsuarioDto encontrarUsuarioPorNombre(String nombre);
    
    public List<UsuarioDto> encontrarUsuarioPorId(Long idUsuario);
    
    public void deleteById(long id);
}
