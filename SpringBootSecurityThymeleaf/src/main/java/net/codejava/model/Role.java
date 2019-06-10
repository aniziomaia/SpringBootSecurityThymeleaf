package net.codejava.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority{

	@Id
	@Column(name = "nameRole")
	private String nameRole;

	@ManyToMany(mappedBy = "roles")
    private List<User> usuarios;
	
	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}

	public List<User> getUsers() {
		return usuarios;
	}

	public void setUser(List<User> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nameRole;
	}
	
	
}
