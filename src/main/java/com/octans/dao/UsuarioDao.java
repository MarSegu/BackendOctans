package com.octans.dao;

import com.octans.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Clase Dao crud
 * @author Mario Segura
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    @Query(value = "SELECT * FROM usuario u "
            + "WHERE u.nombre LIKE %?1%", nativeQuery = true)
    Usuario findByNombre(@Param("nombre") String nombre);
    
    List<Usuario> findByIdUsuario(Long idUsuario);
}
