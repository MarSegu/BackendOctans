package com.octans.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.octans.dto.UsuarioDto;
import com.octans.model.Usuario;

@Component
public class UsuarioConverterImpl implements UsuarioConverter{

	private Usuario usuario;
	private UsuarioDto usuarioDto;
	private List<UsuarioDto> usuariosDto;
	
	public UsuarioConverterImpl() {
		
		this.usuario = new Usuario();
		this.usuarioDto = new UsuarioDto();
		this.usuariosDto = new ArrayList<>();
	}

	@Override
	public Usuario converterUsuarioDtoToUsuario(UsuarioDto usuarioDto) {
		if(usuarioDto != null) {
			this.usuario.setIdUsuario(usuarioDto.getIdUsuario());
			this.usuario.setNombre(usuarioDto.getNombre());
			this.usuario.setActivo(usuarioDto.getActivo());
			this.usuario.setRol(usuarioDto.getRol());
			return this.usuario;
		}
		return null;
	}

	@Override
	public UsuarioDto converterUsuarioToUsuarioDto(Usuario usuario) {
		if(usuario != null) {
			this.usuarioDto.setIdUsuario(usuario.getIdUsuario());
			this.usuarioDto.setNombre(usuario.getNombre());
			this.usuarioDto.setActivo(usuario.getActivo());
			this.usuarioDto.setRol(usuario.getRol());
			return this.usuarioDto;
		}
		return null;
	}

	@Override
	public List<UsuarioDto> converterUsuarioListToUsuarioDtoList(List<Usuario> usuarios) {
		this.usuariosDto = new ArrayList<>();
        for(Usuario usuarioVar : usuarios){
        	this.usuarioDto = new UsuarioDto();
			this.usuarioDto.setIdUsuario(usuarioVar.getIdUsuario());
			this.usuarioDto.setNombre(usuarioVar.getNombre());
			this.usuarioDto.setActivo(usuarioVar.getActivo());
			this.usuarioDto.setRol(usuarioVar.getRol());
            this.usuariosDto.add(this.usuarioDto);
        }
        return this.usuariosDto;
        
	}

}
