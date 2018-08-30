package com.papaneto.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papaneto.api.dtos.EmpresaDto;
import com.papaneto.api.responses.Response;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@GetMapping(value = "/{id}")
	public String getOne(@PathVariable("id") Long id) {
		return "id selecionado: " + id;
	}
	
	@PostMapping
	public ResponseEntity<Response<EmpresaDto>> save(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result) {
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		empresaDto.setId(1L);
		response.setData(empresaDto);
		
		return ResponseEntity.ok(response);
	}
}
