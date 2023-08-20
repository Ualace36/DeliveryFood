package com.delivery.deliveryfood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.delivery.deliveryfood.DeliveryFoodApplication;
import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;



public class ConsultaCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		List<Cozinha> cozinhas = cadastroCozinha.listar();
	    
		for(Cozinha cozinha : cozinhas ) {
	    	System.out.println(cozinha.getNome());
	    }
	}

}
