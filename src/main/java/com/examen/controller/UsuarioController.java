package com.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.excepciones.ResourceNotFoundException;
import com.examen.model.Usuario;
import com.examen.repository.IUsuarioRepository;
import com.examen.service.IUsuarioService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200" )
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioService.listar();
	}
	
	
	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestBody Usuario u) {
		return usuarioService.crear(u);
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id){
		Usuario usuario = usuarioService.buscarPorId(id).orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ID : " + id));
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id,@RequestBody Usuario usuarioBody){
		Usuario usuario = usuarioService.buscarPorId(id).orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con ID : " + id));
		
		usuario.setId_usuario(usuarioBody.getId_usuario());
		usuario.setUsuario(usuarioBody.getUsuario());
		usuario.setEmail(usuarioBody.getEmail());
		usuario.setPassword(usuarioBody.getPassword());
		usuario.setRol(usuarioBody.getRol());
		usuario.setFullName(usuarioBody.getFullName());
		usuario.setAvatar(usuarioBody.getAvatar());
		
		Usuario usuarioNuevo = usuarioService.actualizar(usuario);
		return ResponseEntity.ok(usuarioNuevo);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable Integer id){
		
		usuarioService.eliminar(id);
	}
}
