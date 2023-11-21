package com.eduardo.lombok.projetoLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eduardo.lombok.projetoLombok.entities.Usuario;
import com.eduardo.lombok.projetoLombok.repositories.UsuarioRepositorio;
@Service
public class UsuarioService {

	private final UsuarioRepositorio usuarioRepositorio;

	public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	public Usuario findUsuarioById(Long id) {
		Optional<Usuario> Usuario = usuarioRepositorio.findById(id);
		return Usuario.orElse(null);
	}

	public List<Usuario> findAllUsuario() {
		return usuarioRepositorio.findAll();
	}

	public Usuario insertUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setEmail(novoUsuario.getEmail());
			return usuarioRepositorio.save(usuarioExistente);
		} else {
			return null;
		}
	}

	public boolean deleteUsuario(Long id) {
		Optional<Usuario> usuarioExistente = usuarioRepositorio.findById(id);
		if (usuarioExistente.isPresent()) {
			usuarioRepositorio.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
