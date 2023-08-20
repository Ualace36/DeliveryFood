package com.delivery.deliveryfood.domain.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository{

	 @PersistenceContext
		private EntityManager manager;
		
	@Override
	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}

	@Override
	public Cozinha buscar(Long id) {
		return  manager.find (Cozinha.class, id);
	}

	@Override
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return  manager.merge(cozinha);
		
		
	}

	@Override
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = buscar (cozinha.getId());
		manager.remove(cozinha);
		
	}

}
