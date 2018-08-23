package com.papaneto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.papaneto.api.entities.Empresa;
import com.papaneto.api.repositories.EmpresaRepository;

@SpringBootApplication
public class SpringThisFuckApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringThisFuckApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("74645215000104");
			
			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Optional<Empresa> optionalEmpresa = empresaRepository.findById(1L);
			Empresa empresaDb = optionalEmpresa.get();
			System.out.println("Empresa por ID: " + empresaDb);
			
			empresaDb.setRazaoSocial("Kazale IT Web");
			this.empresaRepository.save(empresaDb);

			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			this.empresaRepository.delete(empresa);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
			
		};
	}
}
