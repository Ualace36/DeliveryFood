package com.delivery.deliveryfood.domain.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.delivery.deliveryfood.domain.model.Permissao;
import com.delivery.deliveryfood.domain.repository.PermissaoRepository;
@Repository
public class PermissaoRepositoryImpl implements PermissaoRepository{

	 @PersistenceContext
     private EntityManager manager;
     
     @Override
     public List<Permissao> listar() {
         return manager.createQuery("from Permissao", Permissao.class)
                 .getResultList();
     }
     
     @Override
     public Permissao buscar(Long id) {
         return manager.find(Permissao.class, id);
     }
     
     @Transactional
     @Override
     public Permissao salvar(Permissao permissao) {
         return manager.merge(permissao);
     }
     
     @Transactional
     @Override
     public void remover(Permissao permissao) {
         permissao = buscar(permissao.getId());
         manager.remove(permissao);
     }

}
