package com.papaneto.api.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDto {
	
	private Long id;
	
	@NotNull(message = "Razão Social não pode estar vazio.")
	@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres.")
	private String razaoSocial;
	
	@NotNull(message = "Cnpj não pode estar vazio.")
	@CNPJ(message = "Cnpj inválido.")
	private String cnpj;
	
	public EmpresaDto() {}

	@Override
	public String toString() {
		return "EmpresaDto [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
	
}
