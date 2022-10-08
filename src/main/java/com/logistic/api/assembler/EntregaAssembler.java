/**
 * 
 */
package com.logistic.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.logistic.api.domain.model.Entrega;
import com.logistic.api.model.EntregaModel;

/**
 * @author manoel.carvalho
 *
 */

@Component
public class EntregaAssembler {
	
	@Autowired
	private ModelMapper modelMapper; 
	
	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
