package com.delivery.deliveryfood.domain.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.delivery.deliveryfood.domain.model.FormaPagamento;
import com.delivery.deliveryfood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	 @PersistenceContext
     private EntityManager manager;
     
     @Override
     public List<FormaPagamento> listar() {
         return manager.createQuery("from FormaPagamento", FormaPagamento.class)
                 .getResultList();
     }
     
     @Override
     public FormaPagamento buscar(Long id) {
         return manager.find(FormaPagamento.class, id);
     }
     
     @Transactional
     @Override
     public FormaPagamento salvar(FormaPagamento formaPagamento) {
         return manager.merge(formaPagamento);
     }
     
     @Transactional
     @Override
     public void remover(FormaPagamento formaPagamento) {
         formaPagamento = buscar(formaPagamento.getId());
         manager.remove(formaPagamento);
     }

}
