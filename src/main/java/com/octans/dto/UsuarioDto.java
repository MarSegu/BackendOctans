package com.octans.dto;

import com.octans.model.Rol;

public class UsuarioDto {
	
    private Long idUsuario;
    
    private String nombre; 
    
    private String activo;
    
    private Rol rol;
    
    

	public UsuarioDto() {
	}
	
	public UsuarioDto(Long idUsuario, String nombre, String activo, Rol rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.activo = activo;
		this.rol = rol;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioDto [idUsuario=" + idUsuario + ", nombre=" + nombre + ", activo=" + activo + ", rol=" + rol
				+ "]";
	}
        
}
