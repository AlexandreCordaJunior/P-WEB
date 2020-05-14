package br.com.quintanoite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Item extends GenericDomain {
	
	@Column (nullable = false)
	private int qtd;
	
	@Column (nullable = false)
	private float valorParc;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto prod;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Venda venda;

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public float getValorParc() {
		return valorParc;
	}

	public void setValorParc(float valorParc) {
		this.valorParc = valorParc;
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	

}
