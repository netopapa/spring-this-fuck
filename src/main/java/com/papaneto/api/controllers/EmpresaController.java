package com.papaneto.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.papaneto.api.dtos.EmpresaDto;
import com.papaneto.api.entities.Empresa;
import com.papaneto.api.responses.Response;
import com.papaneto.api.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;

	@GetMapping(value = "/{id}")
	public String getOne(@PathVariable("id") Long id) {
		return "id selecionado: " + id;
	}
	
	@RequestMapping(method= RequestMethod.POST, path="/save")
	public ResponseEntity<Response<Empresa>> save(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result) {
		Response<Empresa> response = new Response<Empresa>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		

		response.setData(this.service.save(empresaDto));
		
		return ResponseEntity.ok(response);
	}
}
