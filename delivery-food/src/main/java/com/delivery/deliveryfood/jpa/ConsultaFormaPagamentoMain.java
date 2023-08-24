package com.delivery.deliveryfood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.delivery.deliveryfood.DeliveryFoodApplication;
import com.delivery.deliveryfood.domain.model.FormaPagamento;
import com.delivery.deliveryfood.domain.repository.FormaPagamentoRepository;



public class ConsultaFormaPagamentoMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(DeliveryFoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
        
        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.listar();
        
        for (FormaPagamento formaPagamento : todasFormasPagamentos) {
            System.out.println(formaPagamento.getDescricao());
        }
	}

}
