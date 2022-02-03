package com.octans.servicio;

import com.octans.dao.UsuarioDao;
import com.octans.dto.UsuarioDto;
import com.octans.mapper.UsuarioConverter;

import java.util.List;
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
    
    private UsuarioDao usuarioDao;
    private UsuarioConverter usuarioConverter;
    List<UsuarioDto> usuarios;
    UsuarioDto usuarioDto;
    
    @Autowired
	public UsuarioServiceImpl(UsuarioDao usuarioDao, UsuarioConverter usuarioConverter) {
		super();
		this.usuarioDao = usuarioDao;
		this.usuarioConverter = usuarioConverter;
	}    
    
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> listarUsuarios() {
        this.usuarios = this.usuarioConverter.converterUsuarioListToUsuarioDtoList(usuarioDao.findAll());
    	return this.usuarios;
    }

    @Override
    @Transactional
    public void guardar(UsuarioDto usuarioDto) {
        usuarioDao.save(this.usuarioConverter.converterUsuarioDtoToUsuario(usuarioDto));
    }

    @Override
    @Transactional
    public void eliminar(UsuarioDto usuarioDto) {
        usuarioDao.delete(this.usuarioConverter.converterUsuarioDtoToUsuario(usuarioDto));
    }

    @Override
    @Transactional()
    public UsuarioDto encontrarUsuarioPorNombre(String nombre) {
    	this.usuarioDto = this.usuarioConverter.converterUsuarioToUsuarioDto(usuarioDao.findByNombre(nombre));
        return this.usuarioDto;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> encontrarUsuarioPorId(Long idUsuario) {
    	this.usuarios = this.usuarioConverter.converterUsuarioListToUsuarioDtoList(usuarioDao.findByIdUsuario(idUsuario));
        return this.usuarios;
    }

    @Override
    public void deleteById(long id) {
        usuarioDao.deleteById(id);
    }


    
}
