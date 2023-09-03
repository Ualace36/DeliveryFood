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

import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;

@RestController
@ResponseBody
@RequestMapping("/cozinhas")
public class CozinhaController {
	
    @Autowired
	private CozinhaRepository cozinhaRepository;
    
    @GetMapping
	public List<Cozinha> lista() {
		return cozinhaRepository.listar();
	}
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha>  buscar(@PathVariable("cozinhaId") Long id) {
    	Cozinha cozinha = cozinhaRepository.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cozinha);
    }
	
}
