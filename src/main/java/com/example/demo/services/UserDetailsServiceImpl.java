package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.User;
import com.example.demo.repositories.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cliente cli = clienteRepository.findByEmail(username);
		if (cli == null) {
			throw new UsernameNotFoundException(String.format("Usuário '%s' não encontrado", username));
		}
		return new User(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
