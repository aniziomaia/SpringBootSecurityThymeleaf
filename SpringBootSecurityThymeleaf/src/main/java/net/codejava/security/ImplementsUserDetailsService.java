package net.codejava.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import net.codejava.repository.UsuarioRepository;



@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>login: " + login);
		net.codejava.model.User usuario = ur.findByLogin(login);
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}else{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>login: " + usuario.getName());
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
		//return usuario;
	}

}
