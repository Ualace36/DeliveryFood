package com.delivery.deliveryfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.deliveryfood.domain.model.Estado;
import com.delivery.deliveryfood.domain.repository.EstadoRepository;

@RestController
@ResponseBody
@RequestMapping("/estados")
public class EstadoController {
	
    @Autowired
	private EstadoRepository estadoRepository;
    
    @GetMapping
	public List<Estado> lista() {
		return estadoRepository.listar();
	}
	
}
