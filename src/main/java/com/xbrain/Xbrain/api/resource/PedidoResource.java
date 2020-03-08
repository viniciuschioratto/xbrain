package com.xbrain.Xbrain.api.resource;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbrain.Xbrain.api.dto.PedidoDTO;
import com.xbrain.Xbrain.model.entity.Pedido;
import com.xbrain.Xbrain.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoResource {
	
	private PedidoService service;
	
	public PedidoResource(PedidoService service) {
		this.service = service;
	}
	
	//Terei o metodo de gravar um pedido(POST) e o metodo de ler os pedidos(GET)
	@PostMapping
	public ResponseEntity salvar(@RequestBody PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setValor(dto.getValor());
		pedido.setBairro(dto.getBairro());
		pedido.setCidade(dto.getCidade());
		pedido.setEstado(dto.getEstado());
		pedido.setNumero(dto.getNumero());
		pedido.setRua(dto.getRua());
		pedido.setId_product(new BigDecimal(120));
		
		pedido = service.salvar(pedido);
		return new ResponseEntity(pedido,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity buscaPorId(@PathVariable("id") Long id) {
		System.out.println(id);
		return service.buscaId(id)
				.map( pedido -> new ResponseEntity(pedido, HttpStatus.OK))
				.orElseGet( () -> new ResponseEntity( HttpStatus.NOT_FOUND));
	}
	
	/*
	 * private PedidoDTO converterParaDTO( Pedido pedido) { return
	 * PedidoDTO.builder() .valor(pedido.getValor()) .bairro(pedido.getBairro())
	 * .cidade(pedido.getCidade()) .estado(pedido.getEstado()) .build(); }
	 */

}
