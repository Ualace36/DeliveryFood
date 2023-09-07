package com.delivery.deliveryfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.deliveryfood.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.model.Restaurante;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;
import com.delivery.deliveryfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
    @Autowired
	private RestauranteRepository restauranteRepository;
    
    @Autowired
    private CozinhaRepository cozinhaRepository;
    
    public Restaurante salvar( Restaurante restaurante) {    
    	Long cozinhaId = restaurante.getCozinha().getId();
    	
    	Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
    	
    	if (cozinha == null) {
    		throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com o código %d. Por favor, inclua um código existente.", cozinhaId));
    	}
    	
    	restaurante.setCozinha(cozinha);
    	return restauranteRepository.salvar(restaurante);    	
    }
	
}
