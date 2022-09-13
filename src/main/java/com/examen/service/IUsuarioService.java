package com.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.model.Usuario;


public interface IUsuarioService {
	
	public List<Usuario> listar();
	public Usuario crear(Usuario u);
	public Usuario actualizar(Usuario u);
	public void eliminar(int id);
	public Optional<Usuario> buscarPorId(int id);

}
