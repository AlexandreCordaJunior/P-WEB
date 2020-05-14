package br.com.quintanoite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto extends GenericDomain{
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(nullable = false)
	private int qtde;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	Fornecedor fornecedor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	

}
