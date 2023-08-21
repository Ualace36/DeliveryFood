package com.delivery.deliveryfood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.delivery.deliveryfood.DeliveryFoodApplication;

import com.delivery.deliveryfood.domain.model.Restaurante;
import com.delivery.deliveryfood.domain.repository.RestauranteRepository;



public class ConsultaRestauranteMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		RestauranteRepository cadastroRestaurante = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> restaurantes = cadastroRestaurante.listar();
	    
		for(Restaurante restaurante : restaurantes ) {
	    	System.out.printf("%s - %f - %s\n",restaurante.getNome(),restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
	    }
	}

}
