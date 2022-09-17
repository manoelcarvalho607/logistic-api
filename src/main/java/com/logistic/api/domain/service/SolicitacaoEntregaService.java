/**
 * 
 */
package com.logistic.api.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistic.api.domain.exception.NegocioException;
import com.logistic.api.domain.model.Cliente;
import com.logistic.api.domain.model.Entrega;
import com.logistic.api.domain.model.StatusEntrega;
import com.logistic.api.domain.repository.ClienteRepository;
import com.logistic.api.domain.repository.EntregaRepository;

/**
 * @author manoel.carvalho
 *
 */

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private CatalogoClienteService catalogoClienteService;
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		/**implementar regras de negocio, ex (entrega só pode ser feita em determinado horário) **/
		
		return entregaRepository.save(entrega);
	}
}
