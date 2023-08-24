package com.delivery.deliveryfood.domain.repository;

import java.util.List;

import com.delivery.deliveryfood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	Permissao buscar (Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);
	
}
