package net.codejava.repository;

import org.springframework.data.repository.CrudRepository;

import net.codejava.model.User;


public interface UsuarioRepository extends CrudRepository<User, String>{

	User findByLogin(String login);
}
