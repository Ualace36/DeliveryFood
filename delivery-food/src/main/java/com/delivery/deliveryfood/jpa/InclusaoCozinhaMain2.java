package com.delivery.deliveryfood.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.delivery.deliveryfood.DeliveryFoodApplication;
import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.model.Restaurante;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;
import com.delivery.deliveryfood.domain.repository.RestauranteRepository;



public class InclusaoCozinhaMain2 {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Italiana");
		cozinha1 = cadastroCozinha.salvar(cozinha1);
		cozinha2 = cadastroCozinha.salvar(cozinha2);
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
		
		RestauranteRepository restaurante = applicationContext.getBean(RestauranteRepository.class);
		Restaurante restauranteOne = new Restaurante();
		restauranteOne.setNome("Buteco do Gaucho");
		restauranteOne.setTaxaFrete(null);
		
	}

}
