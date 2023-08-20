package com.delivery.deliveryfood.jpa;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.delivery.deliveryfood.DeliveryFoodApplication;
import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;



public class AlteracaoCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(2L);
		cozinha.setNome("Brasileira");
		cadastroCozinha.salvar(cozinha);
	    System.out.println();
		
	}

}
