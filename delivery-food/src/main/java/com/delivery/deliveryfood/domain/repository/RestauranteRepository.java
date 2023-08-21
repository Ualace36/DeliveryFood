package com.delivery.deliveryfood.domain.repository;

import java.util.List;

import com.delivery.deliveryfood.domain.model.Restaurante;


public interface RestauranteRepository {
	
	List<Restaurante> listar();
	Restaurante buscar (Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);

}
