package net.codejava.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET,  "/**").permitAll()//pagina index liberada para todos
		.antMatchers(HttpMethod.POST,  "/**").permitAll()//pagina index liberada para todos
//		.antMatchers(HttpMethod.GET,  "/new").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.POST, "/new").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.GET,  "/save").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.POST, "/save").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.GET,  "/edit").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.POST, "/edit").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.GET,  "/delete").hasRole("ADMIN")//metodo do controller restringido
//		.antMatchers(HttpMethod.POST, "/delete").hasRole("ADMIN")//metodo do controller restringido
		//.antMatchers(HttpMethod.GET,  "/cadastrarEvento").hasAnyRole("ADMIN")//metodo do controller restringido
		//.antMatchers(HttpMethod.POST, "/cadastrarEvento").hasAnyRole("ADMIN")//metodo do controller restringido
		.anyRequest().authenticated()
		.and().formLogin().permitAll()//fomulario de login do spring
		//.and().formLogin().loginPage("/entrar").permitAll()//fomulario de login personalizado
		//.and().logout().logoutSuccessUrl("/entrar?logout")//desloga pelo botao sair
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));//desloga pela url (http://localhost:8080/entrar?logout)
		
	}//new_product
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		/** autenticacao via jpa com os dados do banco de dados*/
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		/** autenticacao em memoria*/
		//auth.inMemoryAuthentication().withUser("root").password("root").roles("ADMIN");
	}

	/**
	 * Desbloqueia as pastas e subpastas para serem acessadas pelo spring
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**", "/template/**");
	}
}
