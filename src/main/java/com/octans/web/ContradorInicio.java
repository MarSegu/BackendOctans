package com.octans.web;

import com.octans.dto.UsuarioDto;
import com.octans.servicio.UsuarioService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase de controlador
 *
 * @author Mario Segura
 */
@org.springframework.stereotype.Controller
@Slf4j
@RequestMapping("/api")
public class ContradorInicio {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<?> inicio() {
        log.info("Ejecutando el controlador de tipo Spring MVC");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            var usuarios = usuarioService.listarUsuarios();
            if (usuarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            String errorResponse = "No fue posible realizar la consulta.";
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users/{nombre}")
    public ResponseEntity<?> getUserByName(@PathVariable("nombre") String nombre) {
        var usuario = usuarioService.encontrarUsuarioPorNombre(nombre);
        if (usuario != null) {
            if (usuario.getNombre() != null || !usuario.getNombre().isEmpty()) {
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            } else {
                String errorResponse = "El objeto no fue encontrado."; 
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        }
        String errorResponse = "El objeto regreso con valor null."; 
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/users")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        try {
            String response = "Usuario Creado exitosamente";
            usuarioService.guardar(usuarioDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String errorResponse = "No fue posible crear el usuario."; 
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UsuarioDto usuarioDto) {
    	List<UsuarioDto> usuarioResult = usuarioService.encontrarUsuarioPorId(id);
        try {
        	if(!usuarioResult.isEmpty()) {
        		UsuarioDto usuarioDtoVar = new UsuarioDto();
        		usuarioDtoVar.setNombre(usuarioDto.getNombre());
        		usuarioDtoVar.setActivo(usuarioDto.getActivo());
        		usuarioDtoVar.setRol(usuarioDto.getRol());

                usuarioService.guardar(usuarioDtoVar);

                return new ResponseEntity<>(HttpStatus.OK);
	            
            } else {
                String errorResponse = "El usuario no fue encontrado."; 
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            String errorResponse = "No fue posible realizar la busqueda."; 
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteuser(@PathVariable("id") long id) {
        try {
            String correctResponse = "Usuario Eliminado";
            usuarioService.deleteById(id);
            return new ResponseEntity<>(correctResponse, HttpStatus.OK);
        } catch (Exception e) {
            String errorResponse = "No fue posible eliminar el registro."; 
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
