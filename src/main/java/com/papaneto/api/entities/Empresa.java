package com.papaneto.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.papaneto.api.entities.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empresa")
public class Empresa extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -774734778916439241L;
	
	@Getter
    @Setter
	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;
	
	@Getter
    @Setter
	@Column(nullable = false)
	private String cnpj;
	
	@Getter
    @Setter
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Getter
    @Setter
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@Getter
    @Setter
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios; 
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + super.getId() + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", funcionarios=" + funcionarios + "]";
	}

}
