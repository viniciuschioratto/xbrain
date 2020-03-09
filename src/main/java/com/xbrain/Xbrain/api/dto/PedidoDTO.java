package com.xbrain.Xbrain.api.dto;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
	
	private List<ProdutosDTO> id_produto;
	
	private BigDecimal valor;
	
	private String rua;
	
	private String numero;
	
	private String bairro;
	
	private String estado;
	
	private String cidade;

	public List<ProdutosDTO> getId_produto() {
		return id_produto;
	}

	public void setId_produto(List<ProdutosDTO> id_produto) {
		this.id_produto = id_produto;
	}

	public BigDecimal getValor() {
		return valor;
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
