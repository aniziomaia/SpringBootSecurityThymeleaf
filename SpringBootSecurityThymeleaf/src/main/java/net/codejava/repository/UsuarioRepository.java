package net.codejava.repository;

import org.springframework.data.repository.CrudRepository;

import net.codejava.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
