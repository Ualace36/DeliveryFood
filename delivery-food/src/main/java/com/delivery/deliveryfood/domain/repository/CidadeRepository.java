package com.delivery.deliveryfood.domain.repository;

import java.util.List;

import com.delivery.deliveryfood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade buscar (Long id);
	Cidade salvar(Cidade cidade);
	void remover(Cidade cidade);
	
}
