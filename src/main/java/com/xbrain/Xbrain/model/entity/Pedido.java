package com.xbrain.Xbrain.model.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="Pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@OneToMany
	@JoinColumn(name="id_purchase")
	private List<Produto> purchase_list;*/
	
	@Column(name = "id_produto")
	private BigDecimal id_product;
	
	@Column(name ="valor")
	private BigDecimal valor;
	
	@Column(name ="rua")
	private String rua;
	
	@Column(name ="numero")
	private String numero;
	
	@Column(name ="bairro")
	private String bairro;
	
	@Column(name ="estado")
	private String estado;
	
	@Column(name ="cidade")
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public List<Produto> getPurchase_list() {
		return purchase_list;
	}

	public void setPurchase_list(List<Produto> purchase_list) {
		this.purchase_list = purchase_list;
	}*/

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getId_product() {
		return id_product;
	}

	public void setId_product(BigDecimal id_product) {
		this.id_product = id_product;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
