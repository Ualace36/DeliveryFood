package com.delivery.deliveryfood.domain.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.delivery.deliveryfood.domain.model.Cidade;
import com.delivery.deliveryfood.domain.repository.CidadeRepository;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository{

	 @PersistenceContext
     private EntityManager manager;
     
     @Override
     public List<Cidade> listar() {
         return manager.createQuery("from Cidade", Cidade.class)
                 .getResultList();
     }
     
     @Override
     public Cidade buscar(Long id) {
         return manager.find(Cidade.class, id);
     }
     
     @Transactional
     @Override
     public Cidade salvar(Cidade cidade) {
         return manager.merge(cidade);
     }
     
     @Transactional
     @Override
     public void remover(Cidade cidade) {
         cidade = buscar(cidade.getId());
         manager.remove(cidade);
     }

}
