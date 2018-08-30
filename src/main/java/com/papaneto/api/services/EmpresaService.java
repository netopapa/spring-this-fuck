package com.papaneto.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papaneto.api.dtos.EmpresaDto;
import com.papaneto.api.entities.Empresa;
import com.papaneto.api.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa save(EmpresaDto empresaDto) {
		Empresa model = new Empresa();
		
		model.setCnpj(empresaDto.getCnpj());
		model.setRazaoSocial(empresaDto.getRazaoSocial());
		
		this.empresaRepository.save(model);
		
		return model;
	}
}
