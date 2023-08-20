package com.delivery.deliveryfood.domain.repository;

import java.util.List;


import com.delivery.deliveryfood.domain.model.Cozinha;


public interface CozinhaRepository {
	
	List<Cozinha> listar();
	Cozinha buscar (Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);

}
