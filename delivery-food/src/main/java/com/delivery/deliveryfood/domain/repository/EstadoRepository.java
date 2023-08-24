package com.delivery.deliveryfood.domain.repository;

import java.util.List;

import com.delivery.deliveryfood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar (Long id);
	Estado salvar(Estado estado);
	void remover(Estado estado);
	
}
