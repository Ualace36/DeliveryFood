package com.delivery.deliveryfood.domain.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.delivery.deliveryfood.domain.model.Estado;
import com.delivery.deliveryfood.domain.repository.EstadoRepository;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
    private EntityManager manager;
    
	
	@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class)
                .getResultList();
	}

	@Override
	public Estado buscar(Long id) {
		// TODO Auto-generated method stub
		 return manager.find(Estado.class, id);
	}

	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		// TODO Auto-generated method stub
		return manager.merge(estado);
	}

	@Transactional
	@Override
	public void remover(Estado estado) {
		estado = buscar(estado.getId());
        manager.remove(estado);
		
	}

	

}
