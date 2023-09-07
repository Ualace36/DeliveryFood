package com.delivery.deliveryfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.deliveryfood.domain.model.Restaurante;
import com.delivery.deliveryfood.domain.repository.RestauranteRepository;

@RestController
@ResponseBody
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping
	public  List<Restaurante> listar(){
		return restauranteRepository.listar();
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		if( restaurante != null) {
		//Podemos utilizar esse return mais enxuto se quisermos.	
		//return ResponseEntity.ok(restaurante);	
		return ResponseEntity.status(HttpStatus.OK).body(restaurante);
		}
		return ResponseEntity.notFound().build();
	}
}
