package com.eduardo.lombok.projetoLombok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.lombok.projetoLombok.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}