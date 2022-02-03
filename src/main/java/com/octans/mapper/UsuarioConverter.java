package com.octans.mapper;

import java.util.List;

import com.octans.dto.UsuarioDto;
import com.octans.model.Usuario;

public interface UsuarioConverter {
	
	Usuario converterUsuarioDtoToUsuario(UsuarioDto usuarioDto);
	
	UsuarioDto converterUsuarioToUsuarioDto(Usuario usuario);

	List<UsuarioDto> converterUsuarioListToUsuarioDtoList(List<Usuario> usuarios);
}
