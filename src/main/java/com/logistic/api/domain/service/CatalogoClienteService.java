/**
 * 
 */
package com.logistic.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistic.api.domain.exception.NegocioException;
import com.logistic.api.domain.model.Cliente;
import com.logistic.api.domain.repository.ClienteRepository;

/**
 * @author manoel.carvalho
 *
 */

@Service
public class CatalogoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	 
	@Transactional 
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este E-mail.");
		};
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
