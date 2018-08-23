package com.papaneto.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.papaneto.api.entities.base.BaseEntity;
import com.papaneto.api.enums.PerfilEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
public class Funcionario extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6971716530860209644L;

	@Getter
	@Setter
	@Column(name = "nome", nullable = false)
	private String nome;

	@Getter
	@Setter
	@Column(name = "email", nullable = false)
	private String email;

	@Getter
	@Setter
	@Column(name = "senha", nullable = false)
	private String senha;

	@Getter
	@Setter
	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Getter
	@Setter
	@Column(name = "valor_hora", nullable = true)
	private BigDecimal valorHora;

	@Getter
	@Setter
	@Column(name = "qtd_horas_trabalho_dia", nullable = true)
	private Float qtdHorasTrabalhoDia;

	@Getter
	@Setter
	@Column(name = "qtd_horas_almoco", nullable = true)
	private Float qtdHorasAlmoco;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

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
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;

	@Getter
	@Setter
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	public Funcionario() {}

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
		return "Funcionario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf + ", valorHora="
				+ valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco=" + qtdHorasAlmoco
				+ ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao
				+ ", empresa=" + empresa + ", lancamentos=" + lancamentos + "]";
	}

}
