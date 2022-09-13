package com.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.model.Usuario;
import com.examen.repository.IUsuarioRepository;

@Service
public class IUsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario crear(Usuario u) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(u);
	}

	@Override
	public Usuario actualizar(Usuario u) {
		return usuarioRepository.save(u);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public Optional<Usuario> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}
	
	

}
