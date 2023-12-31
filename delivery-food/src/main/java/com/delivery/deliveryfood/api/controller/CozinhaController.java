package com.delivery.deliveryfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.deliveryfood.domain.exception.EntidadeEmUsoException;
import com.delivery.deliveryfood.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.deliveryfood.domain.model.Cozinha;
import com.delivery.deliveryfood.domain.repository.CozinhaRepository;
import com.delivery.deliveryfood.domain.service.CadastroCozinhaService;

@RestController
@ResponseBody
@RequestMapping("/cozinhas")
public class CozinhaController {
	
    @Autowired
	private CozinhaRepository cozinhaRepository;
    @Autowired
    private CadastroCozinhaService cadastroCozinha;
    
    @GetMapping
	public List<Cozinha> lista() {
		return cozinhaRepository.listar();
	}
    
   
    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha>  buscar(@PathVariable("cozinhaId") Long id) {
    	Cozinha cozinha = cozinhaRepository.buscar(id);
    	if(cozinha != null) {
    		return ResponseEntity.status(HttpStatus.OK).body(cozinha);
    	}
    	//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	return ResponseEntity.notFound().build();
    }
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
    	return cadastroCozinha.salvar(cozinha);
    }
    
    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,@RequestBody Cozinha cozinha ) {
		
			Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
		if(cozinhaAtual != null) {
			//cozinhaAtual.setNome(cozinha.getNome());
			 BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		    cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);
	    	return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();
		
		}
    
    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<?> remover(@PathVariable Long cozinhaId){
    	try {
    	cadastroCozinha.excluir(cozinhaId);
		return ResponseEntity.noContent().build();
		
    	}catch (EntidadeNaoEncontradaException e) {
    		return ResponseEntity.notFound().build();
    		
    	}catch(EntidadeEmUsoException e) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
      }
		
   }    	
    
}
