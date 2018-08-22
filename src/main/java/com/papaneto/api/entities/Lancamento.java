package com.papaneto.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.papaneto.api.entities.base.BaseEntity;
import com.papaneto.api.enums.TipoEnum;

import lombok.Getter;
import lombok.Setter;

public class Lancamento extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7217822711031681273L;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;

	@Getter
	@Setter
	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Getter
	@Setter
	@Column(name = "localizacao", nullable = true)
	private String localizacao;

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
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.EAGER)
	private Funcionario funcionario;

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
		return "Lancamento [data=" + data + ", descricao=" + descricao + ", localizacao=" + localizacao
				+ ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", tipo=" + tipo
				+ ", funcionario=" + funcionario + "]";
	}

}
